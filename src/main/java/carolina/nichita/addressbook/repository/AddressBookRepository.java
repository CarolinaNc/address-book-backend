package carolina.nichita.addressbook.repository;

import carolina.nichita.addressbook.model.UserAddress;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class AddressBookRepository {
    List<UserAddress> userAddressList = new ArrayList<UserAddress>();

    public AddressBookRepository() {
        UserAddress userAddress1 =  new UserAddress(
                UUID.randomUUID().toString(),
                "Carolina Nichita",
                "123 Main Street",
                "New York",
                "NY 12345",
                "nnheo@example.com"
        );

        UserAddress userAddress2 =  new UserAddress(
                UUID.randomUUID().toString(),
                "Mihaela Nichita",
                "Hendrick Street",
                "Amsterdam",
                "MH 1245",
                "mihaelaeo@example.com"
        );

        UserAddress userAddress3 =  new UserAddress(
                UUID.randomUUID().toString(),
                "Sofia Eugenia",
                "Johannes Street",
                "Rotterdam",
                "DX 12385",
                "sofiao@example.com"
        );

        UserAddress userAddress4 =  new UserAddress(
                UUID.randomUUID().toString(),
                "Naomi Muller",
                "45 Fredrick Street",
                "Amsterdam",
                "TV 1187",
                "naomio@example.com"
        );



        userAddressList.addAll(Arrays.asList(userAddress1, userAddress2, userAddress3, userAddress4));
    }

    public List<UserAddress> getBookList() {
        return userAddressList;
    }

    public UserAddress findById(String id) {
        for (UserAddress userAddress : userAddressList) {
            if (userAddress.getId().equals(id)) {
                return userAddress;
            }
        }
        return null;
    }

    public UserAddress addBook(UserAddress userAddress) {
        userAddressList.add(userAddress);
        return userAddress;
    }

    public void updateBook(UserAddress userAddress) {
        System.out.println(userAddress);

        UserAddress existingUserAddress = userAddressList
                .stream()
                .filter(b -> b.getId().equals(userAddress.getId())).findFirst().orElseThrow(() -> new IllegalArgumentException("Address not found"));

        System.out.println(existingUserAddress);


        int index = userAddressList.indexOf(existingUserAddress);
        userAddressList.set(index, userAddress);
    }

    public void deleteItem(String id) {
        userAddressList.removeIf(item -> item.getId().equals(id));
    }

    public UserAddress findByFullName(String fullName) {
        for (UserAddress userAddress : userAddressList) {
            if (userAddress.getFullName().equals(fullName)) {
                return userAddress;
            }
        }
        return null;
    }
}
