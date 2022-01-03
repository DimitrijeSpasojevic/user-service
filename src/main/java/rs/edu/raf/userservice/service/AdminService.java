package rs.edu.raf.userservice.service;


public interface AdminService {

    void denyAccess(Long userId);

    void allowAccess(Long userId);
}
