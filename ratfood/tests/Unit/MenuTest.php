<?php

namespace Tests\Unit;

use Tests\TestCase;

class MenuTest extends TestCase
{
    //    public function test_index()
    //    {
    //         $this->json("post","/api/restaurant", [
    //         "name" => "McTest2",
    //         "description" => "Tous les tests que tu souhaites",
    //         "grade" => 5,
    //         "localization" => "Laravel",
    //         "phone_number" => "01 42 42 42 42",
    //         "website" => "testest.fr",
    //         "hours" => "24h/24 7j/7"
    //         ]);

    //         $test_id = $this->get("/api/restaurants")[6]["_id"];

    //        $response = $this->get("/api/restaurant/{$test_id}/menus");

    //        $response->assertStatus(200);
    //     }

    //     public function test_create_menu()
    //     {
    //         $test_id = $this->json('get', "/api/restaurants")[6]["_id"];

    //         $response = $this->json("post", "/api/restaurant/{$test_id}/menu", [
    //             "name" => "Menu Test",
    //             "description" => "8 unit, 4 test, 12 réussites",
    //             "price" => 0
    //     ]);

    //          $response->assertStatus(200);
    //     }

    //     public function test_bad_header_for_create()
    //     {
    //         $test_id = $this->get("/api/restaurants")[6]["_id"];

    //         $response = $this->json("post", "/api/restaurant/{$test_id}/menu", [
    //             "name" => "Menu Test",
    //             "price" => "Int"
    //     ]);

    //         $response->assertStatus(400);
    //     }

    //     public function test_create_menu_in_bad_rest()
    //     {
    //         $response = $this->json("post", "/api/restaurant/1/menu", [
    //             "name" => "Menu Test",
    //             "description" => "8 unit, 4 test, 12 réussites",
    //             "price" => 0
    //         ]);

    //         $response->assertStatus(400);
    //     }
}
