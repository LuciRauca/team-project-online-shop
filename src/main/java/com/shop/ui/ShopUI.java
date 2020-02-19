package com.shop.ui;

import com.shop.ui.ui_handlers.InputPopUps;
import com.shop.ui.ui_handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.security.UserContext;

class ShopUI {
    private AdminShopUI adminShopUI = new AdminShopUI();
    private AdminManageAccountsUI adminManageAccountsUI = new AdminManageAccountsUI();
    void start() throws ShopException {
        String userInput = null;
        final String SHOP = "1";
        final String Account = "2";
        final String Logout = "0";
        do {
            PrintUI.printBox("Welcome to Our Shop", "Shop : 1", "Account : 2", "Logout : 0");
            userInput = InputPopUps.input("Option:");
                    switch (userInput) {
                        case SHOP : {
                            if (UserContext.isAdminLogged()){
                                adminShopUI.manageProducts();
                            }
                            else {
                                PrintUI.printBox("Still missing UserSHopUi");
                            }
                            break;
                        }
                        case Account : {
                            if (UserContext.isAdminLogged()){
                                adminManageAccountsUI.manageAccounts();
                            }
                            else {
                                PrintUI.printBox("User account");
                            }
                            break;
                        }
                        case Logout : {
                            UserContext.setLoggedUser(null);
                            PrintUI.printBox("Logging out");
                        }
                        default: {
                            PrintUI.printBox("Please insert a valid option.");
                        }
                    }
        } while (!userInput.equals(Logout));
    }
}
