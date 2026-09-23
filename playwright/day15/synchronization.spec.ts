import { test, expect } from '@playwright/test';

test('Day 15 - Playwright synchronization', async ({ page }) => {

    await page.goto('https://www.google.com');

    const searchBox = page.getByRole('combobox', { name: 'Search' });

    await searchBox.fill('Playwright');

    await searchBox.press('Enter');

    await expect(page).toHaveTitle(/Playwright/);
});