<?php

namespace Tests\Unit;

use Tests\TestCase;

class UserTest extends TestCase
{
    public function test_index()
    {
        $response = $this->get('/api/users');
        $response->assertStatus(200);
    }

    public function test_register()
    {
        $response = $this->json("post", "/api/register", [
                "username" => "Mr T",
                "firstname" => "Jean-Michel",
                "name" => "Test",
                "email" => "test@gmail.com",
                "password" => "mauvaismdp123",
                "age" => 201,
        ]);
        $response->assertStatus(201);
    }

    public function test_if_already_register()
    {
        $response = $this->json("post", "/api/register", [
            "username" => "Mr T",
            "firstname" => "Jean-Michel",
            "name" => "Test",
            "email" => "test@gmail.com",
            "password" => "mauvaismdp123",
            "age" => 201,
    ]);
        $response->assertStatus(400);
    }

    public function test_bad_header() 
    {
        $response = $this->json("post", "/api/register", [
            "username" => "M",
            "firstname" => "Jean-Michel",
            "name" => "Test",
            "password" => "mauvaismdp123",
            "age" => "Not int",
    ]);
        $response->assertStatus(400);
    }

    public function test_login() 
    {
        $response = $this->json("post", "/api/auth", [
            "username" => "Mr T",
            "password" => "mauvaismdp123",
    ]);
        $response->assertStatus(200);
    }

    public function test_bad_login()
    {
        $response = $this->json("post", "/api/register", [
            "username" => "Mr T",
            "password" => "mauvaismdp456",
    ]);
        $response->assertStatus(400);
    }

    public function test_update()
    {
        $id_test = $this->get("/api/users")[15]["_id"];

        $response = $this->json("put", "/api/user/{$id_test}", [
            "username" => "Mr T",
            "firstname" => "Jean-Michel",
            "name" => "Je ne suis plus un test",
            "age" => 201,
        ]);

        $response->assertStatus(200);
    }

    public function test_delete()
    {
        $id_test = $this->get("/api/users")[15]["_id"];

        $response = $this->json("delete", "/api/user/{$id_test}");

        $response->assertStatus(200);

    }

    public function test_user_not_exist()
    {
        $response = $this->json("delete", "/api/user/1");

        $response->assertStatus(400);
    }
}
