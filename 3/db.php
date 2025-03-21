<?php

$host = 'localhost';
$user = 'root';
$password = '';
$dbname = 'ingatlan';

$conn = new mysqli($host, $user, $password, $dbname);

if ($conn->connect_error) {
    die("Kapcsolódási hiba: " . $conn->connect_error);
}
?>
