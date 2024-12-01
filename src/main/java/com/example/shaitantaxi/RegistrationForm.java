package com.example.shaitantaxi;

class RegistrationForm {

    public function registerUser($username, $password, $email) {
        $db->insert("users", [
                "username" => $username,
                "password" => password_hash($password, PASSWORD_BCRYPT),
                "email" => $email
        ]);
    }
}

