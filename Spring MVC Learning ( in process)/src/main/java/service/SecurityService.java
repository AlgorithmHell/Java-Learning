package service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String Username,String Password);
}
