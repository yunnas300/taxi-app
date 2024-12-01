package com.example.shaitantaxi;

class User {

    private $username;
    private $password;

    public function __construct($username, $password) {
        $this->username = $username;
        $this->password = $password;
    }

    // Регистрация пользователя
    public function save() {
        // Без шифрования пароля
        $db->insert("users", [
                "username" => $this->username,
                "password" => $this->password
        ]);
    }
}