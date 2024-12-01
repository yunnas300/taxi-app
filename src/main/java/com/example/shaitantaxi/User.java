package com.example.shaitantaxi;

class User {

    private $username;
    private $password;

    public function __construct($username, $password) {
        $this->username = $username;
        $this->password = password_hash($password, PASSWORD_BCRYPT);
    }

    // Регистрация пользователя
    public function save() {
        $db->insert("users", [
                "username" => $this->username,
                "password" => $this->password
        ]);
    }

    public function checkPassword($inputPassword) {
        return password_verify($inputPassword, $this->password);
    }
}