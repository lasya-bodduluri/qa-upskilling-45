import { test, expect } from '@playwright/test';

test('SauceDemo login', async ({ page }) => {

    await page.goto('https://www.saucedemo.com/');

    // 1. ID locator
    await page.locator('#user-name').fill('standard_user');

    // 2. Name locator
    await page.locator('[name="password"]').fill('secret_sauce');

    // 3. Class locator
    // Example: locate using a class
    // page.locator('.form_input')

    // 4. Tag locator
    // Example: locate all input elements
    // page.locator('input')

    // 5. Link text locator
    // Example:
    // page.getByText('Products')

    // 6. Partial link/text locator
    // Example:
    // page.getByText('Product', { exact: false })

    // 7. Login button
    await page.locator('#login-button').click();

    // 8. Verify successful login
    await expect(page).toHaveURL(/inventory.html/);


});