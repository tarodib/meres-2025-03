<?php
header("Content-Type: application/json");
$method = $_SERVER['REQUEST_METHOD'];

error_reporting(E_ALL);
ini_set('display_errors', 1);

try {
    $pdo = new PDO("mysql:host=localhost;dbname=ingatlan;charset=utf8", "root", "", [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
    ]);
} catch (PDOException $e) {
    http_response_code(500);
    echo json_encode(["error" => "Database connection failed: " . $e->getMessage()]);
    exit;
}

switch ($method) {
    case 'GET':
        try {
            $stmt = $pdo->query("SELECT ingatlan.id, kategoriak.nev AS kategoria, ingatlan.leiras, ingatlan.hirdetesDatuma, ingatlan.tehermentes, ingatlan.ar, ingatlan.kepUrl FROM ingatlan JOIN kategoriak ON ingatlan.kategoria = kategoriak.id");
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
            echo json_encode(["success" => true, "data" => $result]);
        } catch (Exception $e) {
            http_response_code(500);
            echo json_encode(["error" => "Query failed: " . $e->getMessage()]);
        }
        break;
    
    case 'POST':
        $data = json_decode(file_get_contents("php://input"), true);
        if (!isset($data['kategoria'], $data['leiras'], $data['ar'])) {
            http_response_code(400);
            echo json_encode(["error" => "Hiányos adatok.", "received_data" => $data]);
            exit;
        }
        try {
            $stmt = $pdo->prepare("INSERT INTO ingatlan (kategoria, leiras, hirdetesDatuma, tehermentes, ar, kepUrl) VALUES (?, ?, NOW(), ?, ?, ?)");
            $stmt->execute([$data['kategoria'], $data['leiras'], $data['tehermentes'] ?? 1, $data['ar'], $data['kepUrl'] ?? null]);
            http_response_code(201);
            echo json_encode(["success" => true, "id" => $pdo->lastInsertId()]);
        } catch (Exception $e) {
            http_response_code(500);
            echo json_encode(["error" => "Insert failed: " . $e->getMessage(), "received_data" => $data]);
        }
        break;
    
    case 'DELETE':
        if (!isset($_GET['id'])) {
            http_response_code(400);
            echo json_encode(["error" => "Hiányzó azonosító."]);
            exit;
        }
        try {
            $stmt = $pdo->prepare("DELETE FROM ingatlan WHERE id = ?");
            $stmt->execute([$_GET['id']]);
            if ($stmt->rowCount() > 0) {
                http_response_code(204);
            } else {
                http_response_code(404);
                echo json_encode(["error" => "Az ingatlan nem létezik."]);
            }
        } catch (Exception $e) {
            http_response_code(500);
            echo json_encode(["error" => "Delete failed: " . $e->getMessage(), "id" => $_GET['id']]);
        }
        break;
}