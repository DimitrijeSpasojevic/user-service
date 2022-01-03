package rs.edu.raf.userservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.userservice.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Override
    public void denyAccess(Long userId) {

    }

    @Override
    public void allowAccess(Long userId) {

    }
}
