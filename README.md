# ShareMyOffer


## About

ShareMyOffer is a web application that allows users to post offers that they come across and connect with others to grab the offer by sharing the discount.



## How it works

- Provision to post the offers.
- Simple search for the list of offers based on location.
- Provision to shop in groups and avail exciting offers.
- Communication between the users who are interested in an offer.
- Provision to notify the user when others agree to grab the offer together.


## Features

- Share offers with others through posts.
- Connect with people around and shop with them.
- Simple UI to view list of available offers.
- Notifications to the user on offer acceptance through Twilio SMS API.


## TechStack 

- Back-End : Spring boot
- Front-End : Thymeleaf, HTML, CSS, JavaScript
- Database : MySQL
- Notifications : Twilio SMS API
- Location : Google Maps API

## Setup
### Requirements
 - Maven
 - A Twilio account - [sign up](https://www.twilio.com/try-twilio)


### Twilio Account Settings

This application should give you a ready-made starting point for writing your
own appointment reminder application. Before we begin, we need to collect
all the config values we need to run the application:

| Config&nbsp;Value | Description                                                                                                                                                  |
| :---------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Account&nbsp;Sid  | Your primary Twilio account identifier - find this [in the Console](https://www.twilio.com/console).                                                         |
| Auth&nbsp;Token   | Used to authenticate - [just like the above, you'll find this here](https://www.twilio.com/console).                                                         |
| Phone&nbsp;number | A Twilio phone number in [E.164 format](https://en.wikipedia.org/wiki/E.164) - you can [get one here](https://www.twilio.com/console/phone-numbers/incoming) |

### Local Development


1. Execute this command in your terminal 
    ```
      export SPRING_APPLICATION_JSON='{"twilio":{
       "ACCOUNT_SID":"<YOUR_ACCOUNT_SID>" ,
       "AUTH_TOKEN": "<YOUR_AUTH_TOKEN>",
       "PATH_SERVICE_SID":"<YOUR_PATH_SERVICE_SID>" 
       }
      }'
      ```



## How to use it 

After the above requirements have been met:

1. Download or clone the repository from [github](https://github.com/NeerajaGoli/ShareMyOffer).

2. Open terminal/command prompt to run the commands provided in local development.

3. Execution
- For a linux or mac os system:
    
     Execute this command in your terminal 
    ``` 
     ./mvnw spring-boot:run
    ``` 
    or
      
      ```
      sudo apt install maven
      mvn clean spring-boot:run
      ```
   
- For a windows system 
   Execute this command in your cmd
    
    ``` 
    ./mvnw spring-boot:run
    ```
    
4. Application will be running on the specified port.
 
5. Open browser and go to localhost:Port_number, login page will open.

6. New user registers using the sign up page , enter your details .
   
   - Password must be of minimum length 8 with 1 uppercase character, 1 number, 1 special character.(eg:Abcd@1234)
   - Format of phone number : Valid 10 digit number
7. Receive the Otp on provided phone number.
8. Enter the Otp to complete the verification process.
9. Login with username(phone number) and password .
10. On the home page, various offers are displayed. Users can search the offers here.
11. On the your offers tab, user offers are displayed. Users can add new posts on the page by clicking the new post button.
12. On the profile tab, user details are displayed.

 

That's it!

## License

[Apache License](http://www.apache.org/licenses/LICENSE-2.0)

## Disclaimer

No warranty expressed or implied. Software is as is.









 
