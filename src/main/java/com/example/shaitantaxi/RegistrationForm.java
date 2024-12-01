package com.example.shaitantaxi;

class RegistrationForm {

    public function registerUser($username, $password, $email) {
        if (strlen($username) > 255) {
            die("Username is too long!");
        }

        if (strlen($password) < 6) {
            die("Password must be at least 6 characters long!");
        }

        if (strlen($email) > 255) {
            die("Email is too long!");
        }

        $db->insert("users", [
                "username" => $username,
                "password" => password_hash($password, PASSWORD_BCRYPT),
                "email" => $email
        ]);
    }
}

