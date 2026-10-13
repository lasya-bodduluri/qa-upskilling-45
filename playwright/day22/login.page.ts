import { Page, Locator } from '@playwright/test';
import { InventoryPage } from './inventory.page';

export class LoginPage {
    readonly page: Page;
    readonly usernameField: Locator;
    readonly passwordField: Locator;
    readonly loginButton: Locator;

    constructor(page: Page) {
        this.page = page;
        // Locators using Playwright shorthand
        this.usernameField = page.locator('#user-name');
        this.passwordField = page.locator('#password');
        this.loginButton = page.locator('#login-button');
    }

    // Action methods with auto-waiting
    async loginAs(user: string, pass: string): Promise<InventoryPage> {
        await this.usernameField.fill(user);
        await this.passwordField.fill(pass);
        await this.loginButton.click();
        return new InventoryPage(this.page);
    }
}