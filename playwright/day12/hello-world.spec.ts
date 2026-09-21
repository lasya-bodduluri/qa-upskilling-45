import { test, expect } from '@playwright/test';

test('Google search title verification', async ({ page }) => {

    await page.goto('https://www.google.com');

    await page.getByRole('combobox', { name: 'Search' }).fill('Playwright');

    await page.keyboard.press('Enter');

    await expect(page).toHaveTitle(/Playwright/);
});