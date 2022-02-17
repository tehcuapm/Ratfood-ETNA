<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Menu;
use Validator;

class MenuController extends Controller
{
    /**
     * Show all menus
     */
    public function allMenu($id)
    {
        return response()->json(Menu::all()->where('id_rest', '=', $id));
    }

    /**
     * Create a menu
     */
    public function createMenu(Request $request, $id)
    {
        $req = Validator::make($request->all(), [
            'name' => 'required|string',
            'description' => 'required|string',
            'price' => 'required|numeric'
        ]);

        if ($req->fails()) {
            return response()->json($req->errors()->toJson(), 400);
        }

        $data = [
            'id_rest' => $id,
            'name' => $request['name'],
            'description' => $request['description'],
            'price' => $request['price'],
        ];

        Menu::create($data);

        return response()->json([
            "message" => "Menu created"
        ], 201);
    }

    /**
     * Update a menu
     */
    public function updateMenu($id, Request $request, $id_menu)
    {
        $req = Validator::make($request->all(), [
            "name" => "required|string",
            "description" => "required|string",
            "price" => 'required|numeric',
        ]);

        if ($req->fails()) {
            return response()->json($req->errors()->toJson(), 400);
        }

        $menus = Menu::all();
        foreach($menus as $item) {
            if($item["_id"] == $id_menu) {
                $item->update([
                    "name" => $request['name'],
                    "description" => $request['description'],
                    "price" => $request['price'],
                ]);
            };
        }

        return response()->json([
            'message' => 'Menu changed',
        ], 200);
    }

    /**
     * Delete menu
     */
    public function deleteMenu($id, $id_menu)
    {
        $rest = Menu::all();
        $is_sup = false;
        foreach($rest as $item) {
            if ($item['_id'] == $id_menu) {
                $item->delete();
                $is_sup = true;
            }
        }
        if ($is_sup) {
            return response()->json([
                'message' => 'Rest deleted',
            ], 200);
        } else {
            return response()->json([
                'message' => 'Rest do not exist',
            ], 400);
        }
    }
}
