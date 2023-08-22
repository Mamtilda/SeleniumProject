# SeleniumProject

This project demonstrates a basic automation testing scenario using Selenium and TestNG. The goal is to automate key interactions on the Amazon.co.uk website, such as launching the site, accepting cookies, searching for products, adding products to the cart, and more.

## Features

- Launch Amazon.co.uk using Firefox WebDriver.
- Accept cookies to enable seamless navigation.
- Search for products (e.g., "speakers") using the search bar.
- Select a product from the search results.
- Add the selected product to the cart.
- Simulate removing the product from the cart.
- Navigate back to the Amazon homepage.

## Setup

1. Clone this repository to your local machine.
2. Make sure you have Firefox installed on your machine.
3. Download the appropriate `geckodriver` executable and set the path in the `amazonLaunch()` method.
4. Update the path to your Firefox binary in the `amazonLaunch()` method.
5. Open the project in your preferred Java IDE.
6. Run the `SeleniumTest` class to execute the test.

## Dependencies

- Selenium WebDriver
- TestNG
- Firefox browser
- GeckoDriver

## Usage

1. Run the `SeleniumTest` class to perform the automated tests on Amazon.co.uk.
2. Observe the interactions and verifications in the console output.
3. The browser window will close automatically after the tests complete.

## Contributions

This project serves as a learning exercise to practice automation testing with Selenium. Feel free to explore and contribute improvements or additional scenarios.

## Future Enhancements

- Implement more test cases to cover a broader range of scenarios.
- Enhance error handling and reporting mechanisms.
- Explore integration with other browsers and headless testing.

## Disclaimer

This project is for educational and learning purposes only. It is not intended for use in production environments. Use responsibly and follow Amazon's terms of service.

