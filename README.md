# ShopifyImageRepository
Java project where users can upload local images to a virtual 'store' and buy pre-existing store images.

# Instructions
To run this program, you will need a recent version Java and have a running IDE to run the Java code.
  1. Download the ZIP file
  2. Run Application.java inside of the src folder

#### Functionalities
- Users are able to sign-up with a new account when they run their system (prompts for name and money in their account)
- Program keeps track of proper inputs (ie. money must be inputted with two decimal places and be between $0.00-$999.99)
- Users can upload images, where they must provide how much the image costs, relevant hashtags, and the filepath to the local file
- Program checks for valid filepaths
- Users can view the store's current gallery
- Users can buy an existing image in the gallery
- Images that users have bought will show up in their local "CustomerImages" folder inside the src folder
- Users can view their personal collection of images

#### Possible Extensions for the Future
- All Customers extend the abstract User class, allowing for other types of User objects in the future (ie. Seller)
- All Images extend the abstract Product class, allowing for other types of Product objects in the future (ie. Video, Music)
- Log-In system for users
- Upload images via selecting a file from their file explorer
- View gallery by looking at the actual images
- Search gallery photos via hashtags

