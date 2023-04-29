package carolina.nichita.addressbook.repository;

import carolina.nichita.addressbook.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class BookingRepository {
    List<User> userList = new ArrayList<User>();

    public BookingRepository() {
        User user1 =  new User(
                UUID.randomUUID().toString(),
                "Carolina Nichita",
                "123 Main Street",
                "New York",
                "NY 12345",
                "nnheo@example.com"
        );

        User user2 =  new User(
                UUID.randomUUID().toString(),
                "Mihaela Nichita",
                "Hendrick Street",
                "Amsterdam",
                "MH 1245",
                "mihaelaeo@example.com"
        );

        User user3 =  new User(
                UUID.randomUUID().toString(),
                "Sofia Eugenia",
                "Johannes Street",
                "Rotterdam",
                "DX 12385",
                "sofiao@example.com"
        );

        User user4 =  new User(
                UUID.randomUUID().toString(),
                "Naomi Muller",
                "45 Fredrick Street",
                "Amsterdam",
                "TV 1187",
                "naomio@example.com"
        );



        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public List<User> getBookList() {
        return userList;
    }

    public User findById(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User addBook(User user) {
        userList.add(user);
        return user;
    }

    public void updateBook(User user) {
        User existingUser = userList
                .stream()
                .filter(b -> b.getId().equals(user.getId())).findFirst().orElseThrow(() -> new IllegalArgumentException("Address not found"));

        int index = userList.indexOf(existingUser);
        userList.set(index, user);
    }

    public void deleteItem(String id) {
        userList.removeIf(item -> item.getId().equals(id));
    }
}
