package org.example;

public class AuthManager {
    private UserRepository userRepository;

    private HashLibrary hashLibrary;

    public AuthManager(UserRepository userRepository, HashLibrary hashLibrary) {
        this.userRepository = userRepository;
        this.hashLibrary= hashLibrary;
    }

    public boolean login(String email, String password) throws NullPointerException
    {
        User user;
        try{
            user= this.userRepository.findByEmail(email);
        }
        catch (NullPointerException nullPointerException)
        {
            throw new NullPointerException();
        }
        if(hashLibrary.getHash(user.getPassword()).equals(hashLibrary.getHash(password)))
        {
            return true;
        }
        else return false;
    }
}
