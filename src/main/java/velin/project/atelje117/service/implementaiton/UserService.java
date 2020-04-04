package velin.project.atelje117.service.implementaiton;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import velin.project.atelje117.mapper.users.UserMapper;
import velin.project.atelje117.model.domain.User;
import velin.project.atelje117.persistence.repositories.IUserRepository;
import velin.project.atelje117.service.services.IUserService;
import velin.project.atelje117.viewmodels.users.UserViewModel;
@Service
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public UserViewModel getUser(int id){

        User user = userRepository.getOne(id);
        UserViewModel userViewModel = new UserMapper().MapToViewModel(user);
        return userViewModel;
    }
}
