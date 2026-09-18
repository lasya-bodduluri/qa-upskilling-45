import { test, expect } from "@playwright/test";

test("Day 14 - Advanced Locators Practice", async ({ page }) => {

    // ==============================
    // TEXT BOX PAGE
    // ==============================

    await page.goto("https://demoqa.com/text-box");

    // 1. ID locator
    const fullName = page.locator("#userName");
    await expect(fullName).toBeVisible();

    // 2. Attribute locator
    const fullNameByPlaceholder = page.locator(
        'input[placeholder="Full Name"]'
    );
    await expect(fullNameByPlaceholder).toBeVisible();

    // 3. Parent relationship
    const inputParent = page.locator(
        "//input[@id='userName']/parent::div"
    );
    await expect(inputParent).toBeVisible();

    // 4. Label locator
    const nameLabel = page.locator(
        "//label[@id='userName-label']"
    );
    await expect(nameLabel).toBeVisible();

    // 5. Following-sibling relationship
    const inputContainer = page.locator(
        "//label[@id='userName-label']/parent::div/following-sibling::div[1]"
    );
    await expect(inputContainer).toBeVisible();

    // 6. Direct-child + adjacent-sibling relationship
    const inputInsideDiv = page.locator(
        "div + div > input#userName"
    );
    await expect(inputInsideDiv).toBeVisible();

    // 7. Email input using ID
    const emailInput = page.locator("#userEmail");
    await expect(emailInput).toBeVisible();

    // 8. Current address using ID
    const currentAddress = page.locator(
        "textarea#currentAddress"
    );
    await expect(currentAddress).toBeVisible();

    // 9. Permanent address using ID
    const permanentAddress = page.locator(
        "textarea#permanentAddress"
    );
    await expect(permanentAddress).toBeVisible();

    // 10. Submit button using ID
    const submitButton = page.locator(
        "button#submit"
    );
    await expect(submitButton).toBeVisible();

    // ==============================
    // ADVANCED CSS LOCATORS
    // ==============================

    // 11. General sibling selector (~)
    await page.goto("https://demoqa.com/checkbox");

    const homeCheckbox = page.locator(
        "span.rc-tree-indent ~ span.rc-tree-checkbox"
    );
    await expect(homeCheckbox.first()).toBeVisible();

    // 12. CSS nth-child()
    await page.goto("https://demoqa.com/text-box");

    const firstFormField = page.locator(
        ".form-group:nth-child(1)"
    );
    await expect(firstFormField).toBeVisible();

    // 13. CSS :not()
    await page.goto("https://demoqa.com/text-box");

    const visibleInputs = page.locator(
        "input:not([type='hidden'])"
    );
    await expect(visibleInputs.first()).toBeVisible();

});