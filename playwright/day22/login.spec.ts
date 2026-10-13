import { test, expect } from '@playwright/test';
import { LoginPage } from './login.page';

test.describe('SauceDemo Login Tests (Playwright)', () => {
    test('should login successfully with valid credentials', async ({ page }) => {
        // 1. Navigate to URL
        await page.goto('https://www.saucedemo.com/');

        // 2. Initialize Login Page
        const loginPage = new LoginPage(page);

        // 3. Perform login and transition to Inventory Page
        const inventoryPage = await loginPage.loginAs('standard_user', 'secret_sauce');

        // 4. Use Playwright's auto-retrying assertions
        await expect(inventoryPage.pageTitle).toBeVisible();
        await expect(inventoryPage.pageTitle).toHaveText('Products');
    });
});