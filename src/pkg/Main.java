package pkg;

public static void main(String[] args){
    UserProfile profile = new UserProfile("Nick", "Foster", "111111", "", Role.OWNER);

    while(!profile.login())
        {
            System.out.println("good job sport!");
        }

}