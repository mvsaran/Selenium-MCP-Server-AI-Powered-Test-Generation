# 🚀 Selenium MCP Server - AI-Powered Test Generation in VS Code (Zero Code Required!)

> Generate complete Selenium TestNG tests using natural language in VS Code - No coding required!

## 📋 Table of Contents
- [What is Selenium MCP?](#what-is-selenium-mcp)
- [Prerequisites](#prerequisites)
- [Setting Up Selenium MCP Server](#setting-up-selenium-mcp-server)
- [Setting Up Maven Project in VS Code](#setting-up-maven-project-in-vs-code)
- [Starting Selenium MCP Server](#starting-selenium-mcp-server)
- [🎯 How to Generate Tests (Zero Code!)](#how-to-generate-tests-zero-code)
- [Example Usage](#example-usage)
- [🆕 Registration Form Automation Example](#registration-form-automation-example)
- [Troubleshooting](#troubleshooting)
- [Resources](#resources)

---

## 🤖 What is Selenium MCP?

**Selenium MCP (Model Context Protocol)** allows VS Code to generate complete, production-ready Selenium tests from simple natural language prompts through AI assistance.

### ✨ Key Features:
- 🎯 **Zero Code Required** - Just describe what you want to test
- 🔍 **Auto-Locator Detection** - No need to provide locators! AI finds the best selectors automatically
- 🤖 **AI-Powered** - AI understands testing best practices and web element identification
- 📝 **Complete Tests** - Generates setup, teardown, assertions, and error handling
- 🔧 **Ready to Run** - Uses modern frameworks like TestNG and WebDriverManager
- ⚡ **Instant** - Get working tests in seconds
- 💻 **VS Code Integration** - Works directly in your development environment

---

## ✅ Prerequisites

Before getting started, ensure you have the following installed:

- 💻 **Visual Studio Code** (latest version)
- ☕ **Java Development Kit (JDK)** 11 or higher
- 📦 **Maven** 3.6 or higher
- 🌐 **Node.js** 16+ and **npm** (for MCP server)
- 🔧 **Extension Pack for Java** (VS Code extension)
- 🤖 **VS Code with AI Assistant** (GitHub Copilot, Cody, or similar with MCP support)

---

## 🛠️ Setting Up Selenium MCP Server

### Step 1: Configure MCP Server in VS Code (Using NPX)

#### Configuration File Location:

1. Navigate to your VS Code MCP configuration file:
   - **Windows**: `C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json`
   - **macOS**: `~/Library/Application Support/Code/User/mcp.json`
   - **Linux**: `~/.config/Code/User/mcp.json`

2. If the file doesn't exist, create it with the following content:

```json
{
  "mcpServers": {
    "selenium": {
      "command": "npx",
      "args": [
        "-y",
        "@angiejones/mcp-selenium"
      ]
    }
  }
}
```

3. Save the file

#### Why NPX?
✅ No manual installation required  
✅ Always uses the latest version  
✅ Cleaner configuration  
✅ No build steps needed

### Step 2: Start the MCP Server in VS Code

After configuring the server, you need to start it manually:

1. **Open Command Palette** in VS Code:
   - Windows/Linux: `Ctrl + Shift + P`
   - macOS: `Cmd + Shift + P`

2. **Type**: `MCP: List Servers`

3. **Select**: `selenium` from the list

4. **Start the Server**: Click on the start/play button or select the option to start

5. **Verify Server Status**: The server should show as "Running" ✅

> ⚠️ **Important**: Make sure the server is in **RUN** condition before generating tests. Check the MCP status indicator in VS Code.

---

## 📁 Project Folder Structure

After setting up your Maven project, your folder structure will look like this:

```
selenium-mcp-tests/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── selenium/
│   │               └── mcp/
│   │                   └── App.java
│   └── test/
│       └── java/
│           └── com/
│               └── selenium/
│                   └── mcp/
│                       ├── RegistrationFormTest.java  🆕 (AI Generated)
│                       └── SampleTest.java            (AI Generated)
│
├── target/                      (Generated after build)
├── pom.xml                      (Maven configuration)
├── package.json                 (Optional)
└── README.md
```

### 📝 Key Directories Explained:

- **`src/test/java/com/selenium/mcp/`** - This is where all your AI-generated test files go
- **`pom.xml`** - Contains all Selenium, TestNG, and WebDriverManager dependencies
- **`target/`** - Contains compiled classes and test reports (auto-generated)
- **Test Files**:
  - `SampleTest.java` - SauceDemo login and cart test
  - `RegistrationFormTest.java` - ParaBank registration form test

> 💡 **Pro Tip**: You don't need to create these test files manually! The MCP server generates them automatically based on your natural language prompts.

---

## 📦 Setting Up Maven Project in VS Code

### Step 1: Install Required Extensions

1. Open VS Code
2. Install the following extensions:
   - ☕ **Extension Pack for Java** (by Microsoft)
   - 🔨 **Maven for Java** (by Microsoft)
   - 🧪 **Test Runner for Java** (by Microsoft)

### Step 2: Create a New Maven Project

#### Option 1: Using Command Palette

1. Press `Ctrl+Shift+P` (Windows/Linux) or `Cmd+Shift+P` (macOS)
2. Type "Java: Create Java Project"
3. Select **Maven** → **maven-archetype-quickstart**
4. Follow the prompts to set up your project

#### Option 2: Using Command Prompt (Recommended)

1. In VS Code, open the terminal dropdown (top-right of terminal area)
2. Select **"Command Prompt"** (instead of PowerShell)
3. Run this exact single-line command:

```cmd
mvn archetype:generate -DgroupId=com.selenium.mcp -DartifactId=selenium-mcp-tests -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

✅ **Expected Output:**

```
[INFO] BUILD SUCCESS
[INFO] Created project directory: selenium-mcp-tests
```

4. Navigate to the project:

```cmd
cd selenium-mcp-tests
```

> ⚠️ **Note**: Use Command Prompt instead of PowerShell to avoid line continuation issues with Maven commands.

### Step 3: Configure `pom.xml`

Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>
    
    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.2</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0</version>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>11</source>
                <target>11</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Step 4: Update Dependencies

```bash
# In VS Code terminal
mvn clean install
```

---

## 🚦 Starting Selenium MCP Server in VS Code

### Manual Start Process (Required)

The MCP server needs to be manually started in VS Code after configuration:

#### Step-by-Step:

1. **Open VS Code Command Palette**
   ```
   Ctrl + Shift + P (Windows/Linux)
   Cmd + Shift + P (macOS)
   ```

2. **Search and Select**
   - Type: `MCP: List Servers`
   - Press Enter

3. **Locate Selenium Server**
   - Find `selenium` in the list of configured servers

4. **Start the Server**
   - Click the **Start** button/icon next to `selenium`
   - Or select the option to start the server

5. **Verify Status**
   - Server status should change to **"Running"** ✅
   - Green indicator or checkmark should appear

> 🔴 **Critical**: The server MUST be in **RUN** condition before you can generate tests!

### Configuration File Location:

```
Windows: C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json
```

### NPX Configuration (Already Set):

```json
{
  "mcpServers": {
    "selenium": {
      "command": "npx",
      "args": ["-y", "@angiejones/mcp-selenium"]
    }
  }
}
```

### ✅ Verify Server is Running

Check the VS Code status bar or MCP panel for:
- ✅ Green indicator for `selenium` server
- ✅ Status shows "Running" or "Active"
- ✅ No error messages in the output panel

---

## 🎯 How to Generate Tests (Zero Code!)

This is where the magic happens! Once your MCP server is configured and running in VS Code, you can generate complete Selenium tests without writing any code.

### Step 1: Ensure MCP Server is Running

1. Open Command Palette: `Ctrl + Shift + P`
2. Type: `MCP: List Servers`
3. Verify `selenium` server shows **"Running"** status ✅

### Step 2: Open Your AI Assistant in VS Code

Use any MCP-compatible AI assistant in VS Code:
- GitHub Copilot Chat
- Cody
- Or any other AI extension with MCP support

### Step 3: Use Natural Language Prompts

Simply describe what you want to test in plain English. The AI will generate the complete test code for you!

### 🔍 No Need to Provide Locators!

**Here's the magic**: You don't even need to tell the AI what locators to use! 

#### ❌ What You DON'T Need to Do:
```
❌ "Use By.id('user-name') to find the username field"
❌ "Locate the button with XPath //button[@id='login']"
❌ "Find element by CSS selector input.form-control"
```

#### ✅ What You ACTUALLY Say:
```
✅ "Fill in the username field with 'standard_user'"
✅ "Click the login button"
✅ "Enter password in the password field"
```

**The MCP server automatically**:
- 🔍 Inspects the web page structure
- 🎯 Identifies the best locators (ID, name, CSS, XPath)
- ✨ Generates optimal element location strategies
- 🛡️ Adds proper waits and error handling
- ✅ Creates production-ready code

### 🧪 Example Prompt (From Our Project):

```
🧪 Generate a Selenium TestNG test that visits https://www.saucedemo.com/
, logs in with standard_user and secret_sauce, verifies the PRODUCTS 
heading, and adds the Sauce Labs Backpack to the cart.
```

**Notice**: No locators mentioned! AI figures out:
- `By.id("user-name")` for username field
- `By.id("password")` for password field  
- `By.id("login-button")` for login button
- `By.xpath("//span[@class='title']")` for PRODUCTS heading
- `By.id("add-to-cart-sauce-labs-backpack")` for cart button

### Step 4: AI Generates Complete Test

The AI assistant will automatically create a **complete, production-ready test** including:

✅ **Package declaration** and all necessary imports  
✅ **WebDriver setup** using WebDriverManager  
✅ **@BeforeMethod** - Initializes browser and navigates to URL  
✅ **@Test method** with proper test logic:
   - Login with credentials
   - Wait for elements to load
   - Verify PRODUCTS heading
   - Find and click "Add to cart" for Sauce Labs Backpack
   - Verify cart badge updates
✅ **@AfterMethod** - Proper cleanup and browser closure  
✅ **Explicit waits** - WebDriverWait with ExpectedConditions  
✅ **Assertions** - TestNG assertions to verify expected behavior  
✅ **Error handling** - Try-catch blocks where needed  

### 📄 What You Get (Without Writing Any Code!):

```java
package com.selenium.mcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class SampleTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void sauceDemoLoginAndAddToCart() {
        // Navigate to Sauce Demo
        driver.get("https://www.saucedemo.com/");
        
        // Login
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")))
            .sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Verify PRODUCTS heading
        WebElement productsHeading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='title']")
            )
        );
        Assert.assertEquals(productsHeading.getText(), "PRODUCTS");
        
        // Add Sauce Labs Backpack to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        
        // Verify cart badge
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "1");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

### 🎉 That's It!

**You didn't write a single line of code** - AI generated everything based on your natural language prompt through the MCP server!

### Step 5: Save and Run

1. **Save the generated code** to your test directory:
   - `src/test/java/com/selenium/mcp/SampleTest.java`

2. **Run the test**:
   ```bash
   mvn test
   ```

3. **Watch it execute** automatically!

---

## 💡 More Prompt Examples

You can generate any type of Selenium test with natural language:

### Example 1: Form Testing
```
Generate a test that fills out a contact form with name, email, and message, 
then verifies the success message appears
```

### Example 2: Navigation Testing
```
Create a test that navigates through a multi-page checkout flow, verifies 
each page title, and completes the purchase
```

### Example 3: Data-Driven Testing
```
Generate a test that logs in with multiple user credentials and verifies 
different dashboard elements for each user type
```

### Example 4: API + UI Testing
```
Create a test that makes an API call to create a user, then verifies 
the user appears in the UI dashboard
```

### Example 5: Registration Form Automation 🆕
```
Create a Selenium Java script that automates the process of filling out 
the registration form on the page at "https://parabank.parasoft.com/parabank/register.htm" 
with fake data. The script should:
1. Navigate to the registration URL
2. Fill out the form with the following fake data:
   - First Name: John
   - Last Name: Doe
   - Address: 123 Fake Street
   - City: Faketown
   - State: FT
   - Zip Code: 12345
   - Phone Number: 5551234567
   - SSN: 123-45-6789
   - Username: johndoe123
   - Password: password123
   - Confirm Password: password123
3. Submit the registration form
4. Wait for the registration to complete using explicit waits
5. Verify the successful registration or page redirection
6. Close the browser after the test

Make sure the script uses ChromeDriver with WebDriverManager and waits 
appropriately for elements to load.
```

---

## 🎯 Why This is Powerful

| Traditional Approach | With Selenium MCP |
|---------------------|-------------------|
| ✍️ Write all code manually | 💬 Describe in natural language |
| 🔍 Inspect elements & find locators | 🤖 AI finds optimal locators automatically |
| ⏱️ Hours to create tests | ⚡ Seconds to generate |
| 🐛 Debug syntax errors | ✅ Production-ready code |
| 📚 Remember API syntax | 🤖 AI knows best practices |
| 🔄 Refactor repeatedly | 🎯 Get it right first time |
| 🧪 Manual element identification | 🔍 Automatic element detection |

---

## 🧪 Example Usage

## 🧪 Real-World Success Story

### Our Project Example:

**What We Did:**
1. ✅ Set up the MCP server (5 minutes)
2. ✅ Created Maven project (2 minutes)
3. ✅ Gave Claude a simple prompt
4. ✅ Got a complete, working test **without writing any code!**

**The Prompt:**
```
🧪 Generate a Selenium TestNG test that visits https://www.saucedemo.com/
, logs in with standard_user and secret_sauce, verifies the PRODUCTS 
heading, and adds the Sauce Labs Backpack to the cart.
```

**The Result:**
- ✅ Complete test class with 50+ lines of professional code
- ✅ All imports and dependencies handled
- ✅ WebDriverManager integration
- ✅ Explicit waits and proper synchronization
- ✅ TestNG annotations and assertions
- ✅ Clean setup and teardown
- ✅ **Ran successfully on first try!**

**Time Saved:** 30-45 minutes of manual coding → 30 seconds with AI

---

## 🆕 Registration Form Automation Example

### The Prompt You Can Use:

```
Create a Selenium Java script that automates the process of filling out 
the registration form on the page at "https://parabank.parasoft.com/parabank/register.htm" 
with fake data. The script should:
1. Navigate to the registration URL
2. Fill out the form with the following fake data:
   - First Name: John
   - Last Name: Doe
   - Address: 123 Fake Street
   - City: Faketown
   - State: FT
   - Zip Code: 12345
   - Phone Number: 5551234567
   - SSN: 123-45-6789
   - Username: johndoe123
   - Password: password123
   - Confirm Password: password123
3. Submit the registration form
4. Wait for the registration to complete using explicit waits
5. Verify the successful registration or page redirection
6. Close the browser after the test

Make sure the script uses ChromeDriver with WebDriverManager and waits 
appropriately for elements to load.
```

> 🔍 **Notice**: You don't specify any locators (like `By.name`, `By.id`, `By.xpath`)! 
> The MCP server automatically inspects the ParaBank page and finds:
> - `By.name("customer.firstName")` for First Name
> - `By.name("customer.lastName")` for Last Name
> - `By.name("customer.address.street")` for Address
> - `By.name("customer.username")` for Username
> - `By.cssSelector("input[value='Register']")` for Submit button
> - And all other optimal locators!

### What You'll Get (Generated by AI):

```java
package com.selenium.mcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class ParaBankRegistrationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void testRegistrationForm() {
        // Navigate to registration page
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        
        // Wait for the form to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.name("customer.firstName")
        ));
        
        // Fill out the registration form
        driver.findElement(By.name("customer.firstName")).sendKeys("John");
        driver.findElement(By.name("customer.lastName")).sendKeys("Doe");
        driver.findElement(By.name("customer.address.street")).sendKeys("123 Fake Street");
        driver.findElement(By.name("customer.address.city")).sendKeys("Faketown");
        driver.findElement(By.name("customer.address.state")).sendKeys("FT");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("5551234567");
        driver.findElement(By.name("customer.ssn")).sendKeys("123-45-6789");
        
        // Username and password fields
        driver.findElement(By.name("customer.username")).sendKeys("johndoe123");
        driver.findElement(By.name("customer.password")).sendKeys("password123");
        driver.findElement(By.name("repeatedPassword")).sendKeys("password123");
        
        // Submit the form
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        
        // Wait for registration success message or page redirect
        WebElement successMessage = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.title, p")
            )
        );
        
        // Verify successful registration
        String pageText = driver.getPageSource();
        Assert.assertTrue(
            pageText.contains("Your account was created successfully") || 
            pageText.contains("Welcome"),
            "Registration was not successful"
        );
        
        System.out.println("✅ Registration completed successfully!");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

### 🎉 What This Test Does:

✅ **Navigates** to ParaBank registration page  
✅ **Waits** for form elements to load properly  
✅ **Fills out** all 11 form fields with test data  
✅ **Submits** the registration form  
✅ **Verifies** successful registration with assertions  
✅ **Cleans up** by closing the browser  
✅ **Uses best practices**: WebDriverManager, explicit waits, proper assertions

### 💡 Key Features:

- **Explicit Waits**: Uses `WebDriverWait` with 15-second timeout
- **Smart Element Location**: AI automatically chose the best locators:
  - `By.name()` for form fields (most reliable for forms)
  - `By.cssSelector()` for submit button
  - No manual locator research needed!
- **Verification**: Checks for success message or welcome text
- **Error Handling**: Proper cleanup in `@AfterMethod`
- **WebDriverManager**: Automatic driver management
- **TestNG Integration**: Full TestNG annotations and assertions

### 🔍 How MCP Found the Locators:

The AI analyzed the ParaBank registration page and automatically discovered:

| Field | AI-Selected Locator | Why This Locator? |
|-------|---------------------|-------------------|
| First Name | `By.name("customer.firstName")` | Most stable for form inputs |
| Last Name | `By.name("customer.lastName")` | Semantic and reliable |
| Address | `By.name("customer.address.street")` | Hierarchical name structure |
| City | `By.name("customer.address.city")` | Clear field identification |
| Username | `By.name("customer.username")` | Standard form naming |
| Password | `By.name("customer.password")` | Secure field locator |
| Submit Button | `By.cssSelector("input[value='Register']")` | Unique button identifier |

**You didn't have to:**
- Open DevTools to inspect elements ❌
- Write XPath expressions ❌
- Test different locators ❌
- Worry about locator stability ❌

**MCP did it all for you!** ✅

### 📊 Running the Test:

Save the file as `ParaBankRegistrationTest.java` in:
```
src/test/java/com/selenium/mcp/ParaBankRegistrationTest.java
```

Run with Maven:
```bash
mvn test -Dtest=ParaBankRegistrationTest
```

Or right-click in VS Code and select **Run Test**

---

## 📊 Test Execution Results

```bash
# Using Maven
mvn test

# Run specific test class
mvn test -Dtest=SampleTest

# Run ParaBank registration test
mvn test -Dtest=ParaBankRegistrationTest

# Using TestNG directly in VS Code
# Right-click on the test file → Run Test
```

---

## 🔧 Troubleshooting

### Common Issues:

#### ❌ MCP Server Not Starting

**Solution:**
```bash
# Verify Node.js is installed
node --version  # Should be 16.x or higher

# Verify NPX is available
npx --version

# Test the MCP server manually
npx -y @angiejones/mcp-selenium
```

**Check Configuration File:**
- Windows: Verify `C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json` exists
- Ensure JSON syntax is correct (no trailing commas)
- Restart VS Code completely

**Start Server Manually:**
1. Open Command Palette: `Ctrl + Shift + P`
2. Type: `MCP: List Servers`
3. Select `selenium` and click Start
4. Verify status shows "Running"

#### ❌ Maven Dependencies Not Resolving

**Solution:**
```bash
# Force update dependencies
mvn clean install -U

# Clear Maven cache
rm -rf ~/.m2/repository
mvn clean install
```

#### ❌ WebDriver Issues

**Solution:**
```java
// Use WebDriverManager in your test setup
import io.github.bonigarcia.wdm.WebDriverManager;

@BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
}
```

#### ❌ VS Code Not Detecting MCP Server

**Solution:**
1. Verify the configuration file path:
   - Windows: `C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json`
2. Ensure the NPX command is correct:
   ```json
   {
     "mcpServers": {
       "selenium": {
         "command": "npx",
         "args": ["-y", "@angiejones/mcp-selenium"]
       }
     }
   }
   ```
3. Restart VS Code completely
4. Manually start the server:
   - Command Palette → `MCP: List Servers` → Select `selenium` → Start
5. Check VS Code output panel for error messages

#### ❌ Element Not Found in ParaBank Test

**Solution:**
```java
// Increase wait time if elements load slowly
wait = new WebDriverWait(driver, Duration.ofSeconds(20));

// Add implicit wait as backup
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Use more flexible locators
wait.until(ExpectedConditions.or(
    ExpectedConditions.presenceOfElementLocated(By.name("customer.firstName")),
    ExpectedConditions.presenceOfElementLocated(By.id("customer.firstName"))
));
```

---

## 📚 Resources

- 📖 **Official MCP Selenium Repository**: [github.com/angiejones/mcp-selenium](https://github.com/angiejones/mcp-selenium)
- 🌐 **Selenium Documentation**: [selenium.dev/documentation](https://www.selenium.dev/documentation/)
- 🧪 **TestNG Documentation**: [testng.org/doc](https://testng.org/doc/)
- 🔧 **Maven Documentation**: [maven.apache.org](https://maven.apache.org/)
- 💻 **VS Code Java**: [code.visualstudio.com/docs/java](https://code.visualstudio.com/docs/java)
- 🤖 **Model Context Protocol**: [modelcontextprotocol.io](https://modelcontextprotocol.io)
- 🏦 **ParaBank Demo Site**: [parabank.parasoft.com](https://parabank.parasoft.com/parabank/index.htm)

---

## 👨‍💻 Author

**Saran Kumar**

---

## 📝 License

This project follows the license terms of the [mcp-selenium](https://github.com/angiejones/mcp-selenium) repository.

---

## 🎯 Quick Start Checklist

- [ ] Install prerequisites (JDK 11+, Maven 3.6+, Node.js 16+)
- [ ] Install VS Code with Java Extension Pack
- [ ] Configure `mcp.json` with NPX command (`C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json`)
- [ ] Create Maven project in VS Code using Command Prompt
- [ ] Add Selenium dependencies to pom.xml (run `mvn clean install`)
- [ ] **🚦 Start MCP Server: Command Palette → `MCP: List Servers` → Select `selenium` → Start**
- [ ] **✅ Verify server status shows "Running"**
- [ ] Open AI Assistant in VS Code (Copilot/Cody)
- [ ] **🎯 Give AI a prompt describing your test**
- [ ] **✨ Watch AI generate complete test code (no coding required!)**
- [ ] Save the generated code to your test directory
- [ ] Run `mvn test` and see it work!

---

## 🌟 Key Takeaway

**You can create comprehensive, production-ready Selenium tests in VS Code without writing a single line of code!** Just:
1. Configure and start the MCP server
2. Describe what you want to test in plain English to your AI assistant
3. Get complete, working code with best practices, proper waits, assertions, and error handling

### 🔍 No Locators Required!

**The biggest advantage**: You never need to provide element locators! The MCP server:
- 🌐 Analyzes the target web page automatically
- 🎯 Identifies the most reliable locators (ID, name, CSS, XPath)
- ✨ Selects the best location strategy for each element
- 🛡️ Adds appropriate waits and error handling
- ✅ Generates production-quality code

### 📋 Two Complete Examples Included:

1. **SauceDemo Login & Cart Test** - E-commerce workflow testing
   - Auto-detected: username field, password field, login button, cart button
   
2. **ParaBank Registration Test** 🆕 - Form automation with validation
   - Auto-detected: 11 form fields with optimal `By.name()` locators
   - Auto-detected: Submit button with `By.cssSelector()`

Both examples demonstrate the power of AI-generated Selenium tests with zero manual coding **and zero manual locator research**!

---

**Happy Testing! 🎉**
