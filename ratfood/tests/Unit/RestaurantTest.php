<?php

namespace Tests\Unit;

use Tests\TestCase;

class RestaurantTest extends TestCase
{
    public function test_index()
    {
        $response = $this->get("/api/restaurants");

        $response->assertStatus(200);
    }

    public function test_create()
    {
        $response = $this->json("post","/api/restaurant", [
            "name" => "McTest",
            "description" => "Tous les tests que tu souhaites",
            "grade" => 5,
            "localization" => "Laravel",
            "phone_number" => "01 42 42 42 42",
            "website" => "testest.fr",
            "hours" => "24h/24 7j/7"
        ]);

        $response->assertStatus(201);
    }

    public function test_bad_header()
    {
        $response = $this->json("post","/api/restaurant", [
            "name" => "McTest",
            "description" => "Tous les tests que tu souhaites",
            "grade" => "Int",
            "localization" => "Laravel",
            "phone_number" => "01 42 42 42 42",
            "hours" => "24h/24 7j/7"
        ]);

        $response->assertStatus(400);
    }

    public function test_put_rest()
    {
        $test_id = $this->get("/api/restaurants")[6]["_id"];

        $response = $this->json("put","/api/restaurant/{$test_id}", [
            "name" => "McTest",
            "description" => "Tous les tests que tu souhaites et même plus !",
            "grade" => 5,
            "localization" => "Laravel and everywhere",
            "phone_number" => "01 42 42 42 42",
            "website" => "testest.fr",
            "hours" => "24h/24 7j/7"
        ]);

        $response->assertStatus(200);
    }

    public function test_bad_header_update()
    {
        $test_id = $this->get("/api/restaurants")[6]["_id"];

        $response = $this->json("put","/api/restaurant/{$test_id}", [
            "name" => "McTest",
            "description" => "Tous les tests que tu souhaites et même plus !",
            "grade" => 5,
            "localization" => "Laravel and everywhere",
            "phone_number" => "01 42 42 42 42",
            "hours" => "24h/24 7j/7"
        ]);

        $response->assertStatus(400);
    }

    public function test_if_rest_not_exist_in_update()
    {
        $response = $this->json("put","/api/restaurant/1", [
            "name" => "McTest",
            "description" => "Tous les tests que tu souhaites et même plus !",
            "grade" => 5,
            "localization" => "Laravel and everywhere",
            "phone_number" => "01 42 42 42 42",
            "website" => "testest.fr",
            "hours" => "24h/24 7j/7"
        ]);

        $response->assertStatus(400);
    }

    public function test_delete()
    {
        $test_id = $this->get("/api/restaurants")[6]["_id"];

        $response = $this->delete("/api/restaurant/{$test_id}");

        $response->assertStatus(200);
    }

    public function test_if_rest_not_exist_in_delete()
    {
        $response = $this->delete("/api/restaurant/1");

        $response->assertStatus(400);
    }
}
