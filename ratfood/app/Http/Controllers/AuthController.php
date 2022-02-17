<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Validator;
use App\Models\User;

class AuthController extends Controller
{

    public function __construct()
    {
        $this->middleware('api', ['except' => ['auth', 'register']]);
    }

    /**
     * Get a JWT via given credentials.
     */
    public function login(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'username' => 'required',
            'password' => 'required|string|min:6',
        ]);

        if ($validator->fails()) {
            return response()->json($validator->errors(), 422);
        }

        if (!$token = auth()->attempt($validator->validated())) {
            return response()->json(['error' => 'Unauthorized'], 401);
        }

        return $this->respondWithToken($token);
    }

    /**
     * Sign up.
     *
     * @return \Illuminate\Http\JsonResponse
     */
    public function register(Request $request)
    {
        $req = Validator::make($request->all(), [
            'username' => 'required|string|unique:users',
            'firstname' => 'required|string',
            'name' => 'required|string|between:2,100',
            'email' => 'required|string|email|max:100|unique:users',
            'password' => 'required|string|min:6',
            'age' => 'required|integer'
        ]);

        if ($req->fails()) {
            return response()->json($req->errors()->toJson(), 400);
        }

        $user = User::create([
            'username' => $request->username,
            'name' => $request->name,
            'firstname' => $request->firstname,
            'email' => $request->email,
            'age' => $request->age,
            'password' => bcrypt($request->password)
        ]);

        return response()->json([
            'message' => 'User signed up',
            'user' => $user
        ], 201);
    }

    /**
     * Sign out
     */
    public function sign_out()
    {
        auth()->logout();
        return response()->json(['message' => 'User logged out']);
    }

    /**
     * Token refresh
     */
    public function refresh()
    {
        return $this->generateToken(auth()->refresh());
    }

    /**
     * User
     */
    public function allUsers()
    {
        return response()->json(User::all());
    }

    /**
     * Generate token
     */
    protected function respondWithToken($token)
    {
        return response()->json([
            'access_token' => $token,
            'token_type' => 'bearer',
            'expires_in' => auth()->factory()->getTTL() * 60
        ]);
    }
    /**
     * Get the guard to be used during authentication.
     *
     * @return \Illuminate\Contracts\Auth\Guard
     */
    public function guard()
    {
        return Auth::guard('api');
    }
}
