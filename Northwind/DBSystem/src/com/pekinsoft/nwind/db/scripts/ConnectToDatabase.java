/*
 * Copyright (C) 2020 PekinSOFT Systems
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * *****************************************************************************
 * Project    :   Northwind
 * Class      :   ConnectToDatabase.java
 * Author     :   Sean Carrick <sean at pekinsoft dot com>
 * Created    :   Dec 4, 2020 @ 7:00:53 PM
 * Modified   :   Dec 4, 2020
 *  
 * Purpose:
 * 	
 * Revision History:
 *  
 * WHEN          BY                  REASON
 * ----------    ------------------- -------------------------------------------
 * Dec 4, 2020    Sean Carrick             Initial creation.
 * *****************************************************************************
 */

package com.pekinsoft.nwind.db.scripts;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openide.util.Exceptions;

/**
 *
 * @author Sean Carrick &lt;sean at pekinsoft dot com&gt;
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class ConnectToDatabase {
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    private Connection con;
    
    // Constructor(s)
    /**
     * Creates a default instance of the ConnectToDatabase class.
     */
    public ConnectToDatabase () throws SQLException {
        doConnect();
    }
    
    public Connection getConnection() throws SQLException {
        return con;
    }
    
    private void doConnect() throws SQLException {
        con = DriverManager.getConnection("jdbc:derby:nwind;create=true;");
        
        doCheckIfTablesExist();
    }
    
    private void doCheckIfTablesExist() throws SQLException {
        // AccountTypes table contains the types of accounts that can be held in
        //+ the Chart of Accounts. These are income (Revenue), expense, assets,
        //+ and liabilities. Each account in the Chart of Accounts ***must*** be
        //+ one of these types.
        if ( !tableExists("accounttypes") )
            createAccountTypesTable();
        
        // Accounts table contains the Chart of Accounts that are used by 
        //+ Northwind Traders. These accounts are all that are needed for the
        //+ vast majority of one-truck owner/operator truck drivers, and all of
        //+ the money generated or spent by the O/O will fit into one of these
        //+ accounts.
        if ( !tableExists("accounts") ) 
            createAccountsTable();
        
        // Fuel journal is used to track all fuel purchases and expense. This 
        //+ journal records more information than the other journals, because
        //+ the fuel expense is the one expense that is simple to reduce for the
        //+ O/O truck driver: slow down, idle less, etc.
        if ( !tableExists("fuel") )
            createFuelJournal();
        
        // The Accounting journal is where all accounting and legal expenses for
        //+ the business are recorded.
        if ( !tableExists("accounting") )
            createJournal("accounting");
        
        // The Communication journal is where all communication expenses for the
        //+ business are recorded.
        if ( !tableExists("communication") )
            createJournal("communication");
        
        // The Fees journal is where all business-related fees are recorded.
        if ( !tableExists("fees") )
            createJournal("fees");
        
        // The Insurance journal is where all insurance expenses for the business
        //+ are recorded.
        if ( !tableExists("insurance") )
            createJournal("insurance");
        
        // The Interest journal is where all business-related interest expenses
        //+ are recorded.
        if ( !tableExists("interest") )
            createJournal("interest");
        
        // The Loading journal is where all loading/unloading expense are
        //+ recorded, as well as dock and port fees.
        if ( !tableExists("loading") )
            createJournal("loading");
        
        // The maintenance types table provides the allowed types of maintenance
        //+ which can be performed. These values are set after the table is 
        //+ created, just like the account types and accounts tables.
        if ( !tableExists("mainttypes") )
            createMaintTypesTable();
        
        // The Maintenance journal is where all maintenance and repair expenses
        //+ are recorded.
        if ( !tableExists("maintenance") )
            createMaintenanceTable();
        
        // The Office journal is where all office expenses are recorded.
        if ( !tableExists("office") )
            createJournal("office");
        
        // The Physicals journal is where all business-related medical expenses
        //+ are recorded.
        if ( !tableExists("physicals") )
            createJournal("physicals");
        
        // The Rent/Lease journal is where all business-related rental and 
        //+ leasing expenses are recorded.
        if ( !tableExists("rent") )
            createJournal("rent");
        
        // The Scales journal is where all scale-related expenses are recorded.
        if ( !tableExists("scales") )
            createJournal("scales");
        
        // The Supplies journal is where all business-related supply expenses,
        //+ other than office supplies, are recorded.
        if ( !tableExists("supplies") )
            createJournal("supplies");
        
        // The Tax/License journal is where all business-related tax and license
        //+ expenses are recorded.
        if ( !tableExists("tax") )
            createJournal("tax");
        
        // The Tolls/Parking journal is where all expenses due to toll charges
        //+ and parking fees are recorded.
        if ( !tableExists("tolls") )
            createJournal("tolls");
        
        // The Travel journal is where all business-related travel expenses are
        //+ recorded.
        if ( !tableExists("travel") )
            createJournal("travel");
        
        // The Uniforms journal is where all business-related clothing expenses
        //+ are recorded.
        if ( !tableExists("uniforms") )
            createJournal("uniforms");
        
        // The Wages journal is where all payroll-related expenses are recorded,
        //+ with the exception of the driver's personal wages.
        if ( !tableExists("wages") )
            createJournal("wages");
        
        // The Maintenance Reserve journal is where all maintenance hold-backs
        //+ are recorded. This is typically a percentage of each load's gross
        //+ revenue, as a buffer against maintenance and breakdown expenses.
        if ( !tableExists("reserves") )
            createJournal("reserves");
        
        // The Credit Card account is where all business-related credit card
        //+ purchases are recorded.
        if ( !tableExists("creditcard") )
            createJournal("creditcard");
        
        // The Fuel Card journal is where money transferred to the fuel card is
        // recorded and removed upon fuel purchases by default.
        if ( !tableExists("fuelcard") )
            createJournal("fuelcard");
        
        // The Primary Checking Account journal tracks the business' primary
        //+ checking account balance and includes deposits and withdrawals.
        if ( !tableExists("checking") )
            createJournal("checking");
        
        // The Primary Savings Account journal tracks the business' primary 
        //+ savings account balance.
        if ( !tableExists("savings") )
            createJournal("savings");
    }
    
    private void createMaintenanceTable() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("CREATE TABLE maintenance (");
        sql.append("id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 5000, INCREMENT BY 1),");
        sql.append("date DATE NOT NULL,");
        sql.append("fromAcct BIGINT NOT NULL CONSTRAINT ACCT_FK REFERENCES accounts,");
        sql.append("odometer BIGINT NOT NULL CONSTRAINT ODO_CHK (odometer > 0),");
        sql.append("location VARCHAR(50) NOT NULL,");
        sql.append("cause LONG VARCHAR NOT NULL,");
        sql.append("workPerformed LONG VARCHAR NOT NULL,");
        sql.append("amount DOUBLE NOT NULL CONSTRAINT AMT_CHK (amount > 0.0),");
        sql.append("maintType BIGINT NOT NULL CONSTRAINT TYPE_FK REFERENCES maintTypes)");
        
        con.createStatement().execute(sql.toString());
    }
    
    private void createMaintTypesTable() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("CREATE TABLE mainttypes (");
        sql.append("id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 50000, INCREMENT BY 1),");
        sql.append("type VARCHAR(40) NOT NULL,");
        sql.append("description VARCHAR(255) NOT NULL)");
        
        con.createStatement().execute(sql.toString());
        
        populateMaintTypesData();
    }
    
    private void populateMaintTypesData() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO mainttypes VALUES(");
        sql.append("DEFAULT,");
        sql.append("'PM',");
        sql.append("'Preventative maintenance, other than oil changes.'),(");
        sql.append("DEFAULT,");
        sql.append("'Oil Change',");
        sql.append("'Any oil change and/or lube job.'),(");
        sql.append("DEFAULT,");
        sql.append("'Repair',");
        sql.append("'Any repair made due to a breakdown, not to include roadside service.'),(");
        sql.append("DEFAULT,");
        sql.append("'Roadside Service',");
        sql.append("'Any roadside service due to blown tires or a breakdown.'),(");
        sql.append("DEFAULT,");
        sql.append("'Tires',");
        sql.append("'Any tire replacement made for the truck.'),(");
        sql.append("DEFAULT,");
        sql.append("'Towing',");
        sql.append("'Any towing charges due to a breakdown.')");
        
        con.createStatement().execute(sql.toString());
    }
    
    private void createJournal(String name) throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("CREATE TABLE ").append(name).append("(");
        sql.append("id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 10000, INCREMENT BY 1),");
        sql.append("date DATE NOT NULL,");
        sql.append("fromAcct BIGINT NOT NULL CONSTRAINT ACCT_FK REFERENCES accounts,");
        sql.append("description VARCHAR(255) NOT NULL DEFAULT '[No description provided]',");
        sql.append("amount DOUBLE NOT NULL DEFAULT 0.00 ");
        sql.append("CONSTRAINT AMT_CHK CHECK (amount >= 0.00),");
        sql.append("posted BOOLEAN NOT NULL DEFAULT FALSE)");
        
        
    }
    
    private void createFuelJournal() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("CREATE TABLE fuel(");
        sql.append("id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1000, INCREMENT BY 5),");
        sql.append("fromAccount BIGINT NOT NULL CONSTRAINT ACCT_FK REFERENCES accounts,");
        sql.append("date DATE NOT NULL,");
        sql.append("odometer BIGINT NOT NULL,");
        sql.append("location VARCHAR(50) NOT NULL,");
        sql.append("dieselGallons DOUBLE NOT NULL DEFAULT 0.0,");
        sql.append("dieselPrice DOUBLE NOT NULL DEFAULT 2.309,");
        sql.append("defPurchased BOOLEAN NOT NULL DEFAULT FALSE,");
        sql.append("defGallons DOUBLE NOT NULL DEFAULT 0.0,");
        sql.append("defPrice DOUBLE NOT NULL DEFAULT 2.709,");
        sql.append("notes LONG VARCHAR NOT NULL DEFAULT '[NO DATA]')");
        
        con.createStatement().execute(sql.toString());
    }
    
    private void createAccountsTable() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("CREATE TABLE accounts(");
        sql.append("id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1000, INCRMENT BY 5),");
        sql.append("type BIGINT NOT NULL CONSTRAINT TYPE_FK REFERENCES accounttypes,");
        sql.append("name VARCHAR(30) NOT NULL,");
        sql.append("description LONG VARCHAR)");
        
        con.createStatement().execute(sql.toString());
        
        populateAccountsTableData();
    }
    
    private void populateAccountsTableData() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO accounts VALUES(");
        sql.append("DEFAULT, 1, 'Accounting', ");
        sql.append("'Use this account for any accounting or legal expenses:\n");
        sql.append("Tax Prep fees\nMonthly accounting fees\nAccounting or ");
        sql.append("tax software costs\nPayroll processing\nLegal fees related ");
        sql.append("to business (not citations or fines, they are not tax ");
        sql.append("deductible)\nAttorney fees\nPre-paid legal charges\n");
        sql.append("Contract fees'),(");
        sql.append("DEFAULT, 1, 'Communication', ");
        sql.append("'Use this account for any communication costs:\n");
        sql.append("Cell Phone\nOffice phone\nSatellite radio\nInternet fees ");
        sql.append("(air card charges, wifi subscriptions)\n");
        sql.append("Fax charges\nPhone cards\nQualComm, PeopleNet, other ELDs");
        sql.append("'),(DEFAULT, 1, 'Fees', ");
        sql.append("'Use this category for any fees charged:\n");
        sql.append("ATM fees\nComcheck fees\nEFS fees\nBank fees\nMoney Order ");
        sql.append("fees\nBroker fees or commissions'),(DEFAULT, 1, 'Fuel', ");
        sql.append("'Use this account for any fuel-related expenses:\n");
        sql.append("Fuel, DEF, Fuel additives'),(DEFAULT, 1, 'Insurance', ");
        sql.append("'Use this account for any insurance costs:\n");
        sql.append("Primary liability\nCargo insurance\nPhysical damage ");
        sql.append("insurance\nNTL (non-trucking liability)\nBobtail insurance");
        sql.append("\nDedhead insurance\nWorkers comp\nWork accident\nHealth ");
        sql.append("insurance\nDisability insurance'),(DEFAULT, 1, 'Interest', ");
        sql.append("'Use this account for any business-related interest ");
        sql.append("charges:\nCredit card interest (charges used for business)\n");
        sql.append("Equipment loan interest (truck, trailer, apu, etc.)\n");
        sql.append("Business load interest'),(DEFAULT, 1, 'Loading', ");
        sql.append("'Use this account for an lumper charges/fees:\n");
        sql.append("Loading\nUnloading\nDock fees\nPort fees'),(DEFAULT, 1, ");
        sql.append("'Maintenance', 'Use this account for any maintenance or ");
        sql.append("repair costs:\nRepairs\nMaintenance\nTruck washes\nTowing");
        sql.append("\nTires\nOil changes\nOil analysis\nParts\nCost of ");
        sql.append("maintaining guard dog'),(DEFAULT, 1, 'Office', ");
        sql.append("'Use this account for any office expenses:\n");
        sql.append("Office supplies\nPaper\nInk cartridges/toner\nSoftware\n");
        sql.append("Office machines\nOnline subscriptions\nEducation/Seminars\n");
        sql.append("Business-related books (audiobooks, DVDs)\n");
        sql.append("Postage\nShipping charges\nPO Box\nPrinting (business ");
        sql.append("cards, invoices, Letterhead, etc.)'),(DEFAULT, 1, 'Physicals', ");
        sql.append("'Use this account for any business-related medical costs:");
        sql.append("\n**Do not put personal medical costs here, as they are ");
        sql.append("not deductible as a business expense.\n");
        sql.append("DOT Physicals\nDrug tests\nSleep apnea testing or related ");
        sql.append("costs\nDrug consortium costs'),(DEFAULT, 1, 'Rent/Lease', ");
        sql.append("'Use this account for any rental fees:\n");
        sql.append("Truck rent\nTrailer rent\nStorage costs\nTool and equipment");
        sql.append(" rental\nOffice rental\nGarage rental'),(DEFAULT, 1, 'Scales', ");
        sql.append("Use this account for any scale fees:\n");
        sql.append("Scale tickets\nPrepass fees'),(DEFAULT, 1, 'Supplies', ");
        sql.append("'Use this account for any misc. stuff:\n");
        sql.append("Hardware, nuts, bolts, etc.\nBuilding materials\n");
        sql.append("Cleaning supplies\nSmall tools\nExpendables'),(DEFAULT, 1, ");
        sql.append("'Tax/License', 'Use this account for all business taxes:\n");
        sql.append("**Do not put in quaterly estimated tax payments or any ");
        sql.append("other federal income tax payments (they are not deductible)\n");
        sql.append("Base plate\nHVUT (Form 2290)\nPermits\nFuel tax\nCDL fees\n");
        sql.append("Mileage tax\nBusiness-related Ad Valorem tax\nOversize/");
        sql.append("Overweight Permits'),(DEFAULT, 1, 'Tolls/Parking', ");
        sql.append("'Use this account for all tolls and parking fees:\n");
        sql.append("Toll tickets\nEZPass, PikePass, etc. (any toll-related ");
        sql.append("services)\nParking fees'),(DEFAULT, 1, 'Travel', ");
        sql.append("'Use this account for any travel-related expenses:\n");
        sql.append("Hotel/Lodging\nRental car\nShowers\nAirfare (business-");
        sql.append("related)\nFerry\nIdleaire/Shorepower'),(DEFAULT, 1, 'Uniforms',");
        sql.append("'Use this account for any uniform costs:\n");
        sql.append("Monogram or logo shirts\nGloves\nWork boots\nCoveralls\n");
        sql.append("Rain gear\nSafety vest, goggles, hard hat\nLaundry'),(");
        sql.append("DEFAULT, 1, 'Wages', 'Use this account for payroll:\n");
        sql.append("**This is not for your personal wages, only wages you pay ");
        sql.append("to someone else.\nDrivers\nOffice personnel\nSales people\n");
        sql.append("Shop personnel'),(DEFAULT, 2, 'Settlement', 'Use this account ");
        sql.append("for any income or revenue into your company:\n");
        sql.append("Linehaul\nTarp pay\nDetention pay\nStop-off pay\nFuel ");
        sql.append("surcharge\nOther accessorial pay'),(DEFAULT, 3, 'Primary ");
        sql.append("Checking Account', 'Use this account to track your ");
        sql.append("checking account balance.'),(DEFAULT, 3, 'Primary Savings ");
        sql.append("Account', 'Use this account to track your savings account ");
        sql.append("balance.'),(DEFAULT, 3, 'Fuel Card', 'Use this account to ");
        sql.append("track your fuel card balance.'),(DEFAULT, 4, 'Credit Card', ");
        sql.append("'Use this account to track your credit card balance for ");
        sql.append("business-related purchases only.'),(DEFAULT, 3, 'Maintenance ");
        sql.append("Reserve', 'Use this account to track your maintenance ");
        sql.append("reserve account and to pay for maintenance and repairs.'),(");
        sql.append("DEFAULT, 3, 'Accounts Receivable', 'Use this account to track ");
        sql.append("how much money is owed to your company.')");
        
        con.createStatement().execute(sql.toString());
    }
    
    private void createAccountTypesTable() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("CREATE TABLE AccountTypes(");
        sql.append("id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1),");
        sql.append("name VARCHAR(30) NOT NULL,");
        sql.append("description VARCHAR(50)");
        sql.append(")");
        
        con.createStatement().execute(sql.toString());
        
        populateAccountTypesTableData();
    }
    
    private void populateAccountTypesTableData() throws SQLException {
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO accounttypes VALUES(");
        sql.append("DEFAULT,");
        sql.append("'Revenue',");
        sql.append("'All monies incoming for the company'.");
        sql.append("),(");
        sql.append("DEFAULT,");
        sql.append("'Expense',");
        sql.append("'All monies paid out on non-permanent things'.");
        sql.append("),(");
        sql.append("DEFAULT,");
        sql.append("'Assets',");
        sql.append("'All items of value owned by the company'.");
        sql.append("),(");
        sql.append("DEFAULT,");
        sql.append("'Liabilities',");
        sql.append("'All debts outstanding for the company'.");
        sql.append(")");
        
        con.createStatement().execute(sql.toString());
    }
    
    // Private Methods and Functions
    private boolean tableExists(String tableName) 
            throws SQLException {
        boolean exists = false;
        
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet result = meta.getTables(null, 
                    null, 
                    tableName.toUpperCase(), 
                    null);
            exists = result.next();
        } catch ( SQLException ex ) {
            Exceptions.printStackTrace(ex);
        }
        
        return exists;
    }

}
