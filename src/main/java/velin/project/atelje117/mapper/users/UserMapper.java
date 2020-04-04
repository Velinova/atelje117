package velin.project.atelje117.mapper.users;

import velin.project.atelje117.model.domain.User;
import velin.project.atelje117.viewmodels.users.UserViewModel;

public class UserMapper {
    public UserViewModel MapToViewModel(User user) {
        UserViewModel viewModel = new UserViewModel();
        viewModel.Name = user.getName();
        viewModel.City = user.getCity();
        viewModel.Surname = user.getSurname();
        viewModel.Id = user.getId();
        viewModel.Role = user.getRoles().iterator().next().name;
        viewModel.Username = user.getUsername();
        return viewModel;
    }
}
