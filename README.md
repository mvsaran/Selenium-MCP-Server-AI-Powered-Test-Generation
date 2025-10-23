# 🚀 Selenium MCP Server - AI-Powered Test Generation (Zero Code Required!)

> Generate complete Selenium TestNG tests using natural language with Claude AI - No coding required!

## 📋 Table of Contents
- [What is Selenium MCP?](#what-is-selenium-mcp)
- [Prerequisites](#prerequisites)
- [Setting Up Selenium MCP Server](#setting-up-selenium-mcp-server)
- [Setting Up Maven Project in VS Code](#setting-up-maven-project-in-vs-code)
- [Starting Selenium MCP Server](#starting-selenium-mcp-server)
- [🎯 How to Generate Tests (Zero Code!)](#how-to-generate-tests-zero-code)
- [Example Usage](#example-usage)
- [Troubleshooting](#troubleshooting)
- [Resources](#resources)

---

## 🤖 What is Selenium MCP?

**Selenium MCP (Model Context Protocol)** allows Claude AI to generate complete, production-ready Selenium tests from simple natural language prompts. 

### ✨ Key Features:
- 🎯 **Zero Code Required** - Just describe what you want to test
- 🤖 **AI-Powered** - Claude understands testing best practices
- 📝 **Complete Tests** - Generates setup, teardown, assertions, and error handling
- 🔧 **Ready to Run** - Uses modern frameworks like TestNG and WebDriverManager
- ⚡ **Instant** - Get working tests in seconds

---

## ✅ Prerequisites

Before getting started, ensure you have the following installed:

- 💻 **Visual Studio Code** (latest version)
- ☕ **Java Development Kit (JDK)** 11 or higher
- 📦 **Maven** 3.6 or higher
- 🌐 **Node.js** and **npm** (for MCP server)
- 🔧 **Extension Pack for Java** (VS Code extension)
- 🤖 **Claude Desktop App** or **Claude Code CLI**

---

## 🛠️ Setting Up Selenium MCP Server

### Step 1: Configure MCP Server in Claude (Using NPX)

#### For Claude Desktop App:

1. Open your Claude configuration file:
   - **Windows**: `C:\Users\yourfolder\AppData\Roaming\Code\User\mcp.json`
   - **macOS**: `~/Library/Application Support/Claude/claude_desktop_config.json`
   - **Linux**: `~/.config/Claude/claude_desktop_config.json`

2. Add the Selenium MCP server configuration using NPX:

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

3. Save the file and restart Claude Desktop App

#### Why NPX?
✅ No manual installation required  
✅ Always uses the latest version  
✅ Cleaner configuration  
✅ No build steps needed

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

## 🚦 Starting Selenium MCP Server

### Automatic Start (NPX Method - Recommended)

When using the NPX configuration, the MCP server automatically starts when you launch Claude Desktop or Claude Code CLI. No manual start required!

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

✅ **Benefits:**
- Automatically starts with Claude
- Always uses the latest version
- No manual installation or build steps
- Self-updating

### ✅ Verify Server is Running

Check the Claude Desktop logs or Claude Code output for:
```
[INFO] Selenium MCP Server started successfully
[INFO] Listening for commands...
```

To verify the configuration file location, check:
- Windows: `C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json`

---

## 🎯 How to Generate Tests (Zero Code!)

This is where the magic happens! Once your MCP server is configured, you can generate complete Selenium tests without writing any code.

### Step 1: Open Claude (Desktop or Code)

Make sure your Selenium MCP server is configured and Claude is running.

### Step 2: Use Natural Language Prompts

Simply describe what you want to test in plain English. Claude will generate the complete test code for you!

### 🧪 Example Prompt (From Our Project):

```
🧪 Generate a Selenium TestNG test that visits https://www.saucedemo.com/
, logs in with standard_user and secret_sauce, verifies the PRODUCTS 
heading, and adds the Sauce Labs Backpack to the cart.
```

### Step 3: Claude Generates Complete Test

Claude will automatically create a **complete, production-ready test** including:

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

**You didn't write a single line of code** - Claude generated everything based on your natural language prompt!

### Step 4: Save and Run

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

---

## 🎯 Why This is Powerful

| Traditional Approach | With Selenium MCP |
|---------------------|-------------------|
| ✍️ Write all code manually | 💬 Describe in natural language |
| ⏱️ Hours to create tests | ⚡ Seconds to generate |
| 🐛 Debug syntax errors | ✅ Production-ready code |
| 📚 Remember API syntax | 🤖 AI knows best practices |
| 🔄 Refactor repeatedly | 🎯 Get it right first time |

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

## 📊 Test Execution Results

```bash
# Using Maven
mvn test

# Run specific test class
mvn test -Dtest=SampleTest

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
- Windows: Verify `C:\Users\yourfolder\AppData\Roaming\Code\User\mcp.json` exists
- Ensure JSON syntax is correct (no trailing commas)
- Restart Claude Desktop completely

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

#### ❌ Claude Not Detecting MCP Server

**Solution:**
1. Verify the configuration file path:
   - Windows: `C:\Users\yourfolder\AppData\Roaming\Code\User\mcp.json`
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
3. Restart Claude Desktop completely
4. Check Claude logs for error messages

---

## 📚 Resources

- 📖 **Official MCP Selenium Repository**: [github.com/angiejones/mcp-selenium](https://github.com/angiejones/mcp-selenium)
- 🌐 **Selenium Documentation**: [selenium.dev/documentation](https://www.selenium.dev/documentation/)
- 🧪 **TestNG Documentation**: [testng.org/doc](https://testng.org/doc/)
- 🔧 **Maven Documentation**: [maven.apache.org](https://maven.apache.org/)
- 💻 **VS Code Java**: [code.visualstudio.com/docs/java](https://code.visualstudio.com/docs/java)

---

## 👨‍💻 Author

**Saran Kumar**

---

## 📝 License

This project follows the license terms of the [mcp-selenium](https://github.com/angiejones/mcp-selenium) repository.

---

## 🎯 Quick Start Checklist

- [ ] Install prerequisites (JDK 11+, Maven 3.6+, Node.js 16+)
- [ ] Configure `mcp.json` with NPX command (`C:\Users\mvsar\AppData\Roaming\Code\User\mcp.json`)
- [ ] Restart Claude Desktop to load MCP server
- [ ] Create Maven project in VS Code using Command Prompt
- [ ] Add Selenium dependencies to pom.xml (run `mvn clean install`)
- [ ] Open Claude and verify MCP server is connected
- [ ] **🎯 Give Claude a prompt describing your test**
- [ ] **✨ Watch Claude generate complete test code (no coding required!)**
- [ ] Save the generated code to your test directory
- [ ] Run `mvn test` and see it work!

---

## 🌟 Key Takeaway

**You can create comprehensive, production-ready Selenium tests without writing a single line of code!** Just describe what you want to test in plain English, and Claude's Selenium MCP integration will generate everything for you - complete with best practices, proper waits, assertions, and error handling.

---

**Happy Testing! 🎉**
