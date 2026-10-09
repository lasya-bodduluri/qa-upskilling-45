
import { test, expect } from '@playwright/test';

// Setup before each test
test.beforeEach(async ({ page }) => {
    await page.goto('https://www.saucedemo.com/');
});

// Login test
test('successful login @smoke', async ({ page }) => {
    await page.locator('#user-name').fill('standard_user');

    await page.locator('#password').fill('secret_sauce');

    await page.locator('#login-button').click();

    // Assertions
    await expect(page).toHaveURL(/inventory\.html/);

    await expect(page.locator('.title')).toHaveText('Products');
});