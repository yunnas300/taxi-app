package com.example.shaitantaxi;

class CSRFProtection {

    public static function generateToken() {
        if (session_status() == PHP_SESSION_NONE) {
            session_start();
        }
        if (empty($_SESSION['csrf_token'])) {
            $_SESSION['csrf_token'] = bin2hex(random_bytes(32));  // Генерация случайного токена
        }
        return $_SESSION['csrf_token'];
    }

    public static function verifyToken($token) {
        if (session_status() == PHP_SESSION_NONE) {
            session_start();
        }
        if ($token !== $_SESSION['csrf_token']) {
            die("CSRF token validation failed");
        }
    }

    public static function addTokenToForm() {
        echo '<input type="hidden" name="csrf_token" value="' . self::generateToken() . '">';
    }
}

