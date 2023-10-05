import java.util.Scanner;

//Connor Aalto, Maria Girgis, Josiah Rondon, Ava Dobro
//To reserialize all data, run TestingSer.java

//To login as admin, use username "admin" and password "9999"
//To login as user, use username "Tyler" and password "9090 "
//*To view the rest of the username and passwords, check the file TestingSer.java. Here, the rest of the information for the MovieNodes are stored as well



public class Main {
    
    //Desirializes information from custumer BST
    BST customers = Deserialize.desCustomers();
    
    //Option menu for admins that we call whenever needing to return back to options 
    public static void adminOptions(Scanner sc) {
        MovieList movielistP = Deserialize.desMovieList();
        System.out.println("|1| See all movies "); //give option to delete least rated
        System.out.println("|2| See/Delete the least rated movie");
        System.out.println("|3| Quit Program");
            String adminChoice = sc.nextLine(); 
            if(adminChoice.equals("1")) {
                System.out.println("Here is a list of all the movies: ");
                movielistP.printMovieList();
                System.out.println("Would you like to continue? Please answer (Y/N)");
                adminChoice = sc.nextLine();
                if(adminChoice.toUpperCase().equals("Y")) {
                    Serialize.serMovieList(movielistP);
                    adminOptions2(sc);
                }
                else if(adminChoice.toUpperCase().equals("N")) {
                    Serialize.serMovieList(movielistP);
                    
                }
            }
            
            if(adminChoice.equals("2")) {
                IdBST moviesID = Deserialize.desMoviesID();
                System.out.println(movielistP.findMin().getTitle()); 
                System.out.print(" is the current least rated movie");
                System.out.println("Would you like to delete the least rated movie? Please answer (Y/N)");
                
                String adminChoice2 = sc.nextLine();

                if(adminChoice2.toUpperCase().equals("N")) {
                    movielistP.findMin();
                    Serialize.serMovieList(movielistP);
                    adminOptions2(sc);
                }
                
            
                if (adminChoice2.toUpperCase().equals("Y")) {
                    System.out.println("Least rated movie deleted!");
                    System.out.println(movielistP.findMin().getTitle());
                    movielistP.deleteMin();
                    Serialize.serMovieList(movielistP);
                    adminOptions2(sc);
               
                }
            }
                if (adminChoice.equals("3")) {
                Serialize.serMovieList(movielistP);
                System.out.println("Thank you and goodbye!");
            }
        }
    
    
    //is called in adminOptions,  so that the function can re-execute
    public static void adminOptions2(Scanner sc){
       adminOptions(sc);
    }

    //Function for user's wish list
    public static void wishListOptions(Scanner sc, WishList wishlist) {
        
      
        
        System.out.println(wishlist.front().getTitle());
        //Options menu for wishlist
        System.out.println("|1| View next movie");
        System.out.println("|2| Delete this movie from the wishlist");
        System.out.println("|3| Add a new movie to the wishlist");
        String input = sc.nextLine();


        if (input.equals("1")) {
            try{
            //System.out.println(wishlist.currentMovie().getTitle());
            wishlist.dequeue();
            wishListOptions(sc, wishlist);
            }catch (Exception e){
                System.out.println("End of list. Type anything to continue");
                userOptions2(sc);
            }

        }

        if (input.equals("2")) {
            try{
            wishlist.dequeue();
            Serialize.serWishList(wishlist);
            wishListOptions(sc, wishlist);
            } catch(Exception e){
                System.out.println("End of list. Type anything to continue");
                userOptions2(sc);
            }
            

        }

        if (input.equals("3")) {
            try{
            IdBST moviesID = Deserialize.desMoviesID();

            System.out.println("What is the Movie ID?");
            int num = sc.nextInt();
            MovieNode newMovie = moviesID.search(num);

            
            if(newMovie.isAvailable() != true){
               System.out.println("Sorry, the current movie is unavaliable and cannot be added to the wishlist.");
            } else {
            wishlist.enqueue(newMovie);
            System.out.println("Succesfully added " + newMovie.getTitle());
            Serialize.serWishList(wishlist);
            wishListOptions(sc, wishlist);
            }
            }catch (Exception e){
                System.out.println("End of list. Type anything to continue");
                userOptions2(sc);
            }
        }
    }
    //displays the customers menu and executes whatever the customer inputs
    
    public static void userOptions(Scanner sc) {
        DateBST moviesDate = Deserialize.desMoviesDate();
        MovieList movielist = Deserialize.desMovieList();
        IdBST moviesID = Deserialize.desMoviesID();
        

        
        System.out.println("|1| Access a movie by ID code");
        System.out.println("|2| See all movies in order of release date");
        System.out.println("|3| View/Alter wishlist");
        System.out.println("|4| Quit Program");
        
        String userChoice = sc.nextLine();

           if(userChoice.equals("1")) {
                movielist.printMovieList();
                System.out.println("Input the ID of the movie you'd like to access:");
                
                int idcode = sc.nextInt();
                MovieNode newMovie = moviesID.search(idcode);

                System.out.println(newMovie.getTitle());
                
                userOptions2(sc);
            }
            //see all movies in order of release date
            else if(userChoice.equals("2")) {
                System.out.println("Here's all the movies in order of release date: ");
                movielist.printMovieList();
                System.out.println("Type anything to advance");
                userOptions2(sc);
                
            }

            else if(userChoice.equals("3")) {

                WishList wishlist = Deserialize.desWishList();
                wishListOptions(sc, wishlist);
                userOptions2(sc); 
                
        }

    
        
            /*else if(userChoice.equals("4")){
               //System.exit();
            }
            */
            //userOptions2(sc);
        
    }
    
    //is called in userOptions, utilizes recursion, so that userOptions mennu can be re run
    public static void userOptions2(Scanner sc){
        sc.nextLine();
        userOptions(sc); 
    }
    
    //main function initizalisez scanner and determines if user is admin or customer
    public static void main(String[]args) {
        
        Scanner sc = new Scanner(System.in);
        loginSystem loginSystem = new loginSystem();
    
        CustomerNode customer = loginSystem.start();
        
        BST customers = Deserialize.desCustomers();

        IdBST moviesID = Deserialize.desMoviesID();
        
        DateBST moviesDate = Deserialize.desMoviesDate();

        WishList Wishlist = Deserialize.desWishList();

        MovieList movielist = Deserialize.desMovieList();

        System.out.println("Please Log-in");
        //deleted == true to see
        if(customer.getAdminStatus()) {
            System.out.println("Hello admin, what would you like to do?");
            adminOptions(sc);
        } else {
            System.out.println("Hello Customer, what would you like to do?");
            userOptions(sc);
            }
        }
    }

