package lab.service;

import lab.entities.dto.request.LoginRequest;
import lab.entities.dto.request.RefreshTokenRequest;
import lab.entities.dto.respond.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
