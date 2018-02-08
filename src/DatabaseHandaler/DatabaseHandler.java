package DatabaseHandaler;

import Admin.AdminInformation;
import Airlines.AirlinesInformation;
import Airport.AirportInformation;
import CustomPackage.UserInformation;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Feeds.Feed;
import Flight.FlightInformation;
import FlightTransitInformation.FlightTransit;
import Flightschedule.FlightSchedule;
import Root.RootInformation;
import SeatInformation.SeatInfo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler {

    //User Table
    String USERTABLENAME = "user";
    //User Table Column
    String USERID = "User_id";
    String USERNAME = "user_name";
    String PASSWORD = "Passord";
    String FIRSTNAME = "FirstName";
    String LASTNAME = "LastName";
    String EMAIL = "Email";
    String PHONE = "Phone";
    String ADDRESS = "Address";

    //Admin Table
    String ADMINTABLENAME = "admin";
    //Admin Table Column
    String ADMINID = "AdminId";
    String ADMINUSERNAME = "AdminUserName";
    String ADMINPASSWORD = "AdminPassword";
    String ADMINEMAIL = "Email";
    String ADMINFIRSTNAME = "FirstName";
    String ADMINLASTNAME = "LastName";

    //Airlines Table
    String AIRLINESTABLENAME = "airlines";
    //Airlines Table Column
    String AIRLINESID = "AirlinesId";
    String AIRLINESNAME = "AirlinesName";
    String AIRLINESADMINID = "AdminId";
    String AIRLINESCOUNTRYNAME = "CountryName";
    String AIRLINESLICENSENO = "LicenseNo";

    //Feeds Table
    String FEEDSTABLENAME = "Feeds";
    //Feeds Table Column
    String FEEDSID = "";
    String FEEDADMINID = "AdminId";
    String FEEDEVENTS = "Events";
    String FEEDDATE = "Date";

    //Airport Table
    String AIRPORTTABLENAME = "Airport";
    //Airport Table Column
    String AIRPORTID = "AirportId";
    String AIRPORTNAME = "AirportName";
    String AIRPORTCOUNTRYNAME = "CountryName";
    String AIRPORTCITYNAME = "CityName";
    String AIRPORTCODE = "AirportCode";
    String AIRPORTADDEDBY = "AdminId";

    //Root Table
    String ROOTTABLENAME = "root";
    //Root Table COlumn
    String ROOTID = "RootId";
    String ROOTDEPARTURECITYAIRPORTCODE = "DepartureCityAirportCode";
    String ROOTDESTINATIONCITYAIRPORTCODE = "DestinationCityAirportCode";
    String ROOTADDEDBY = "AdminId";

    //Flight Table
    String FLIGHTTABLENAME = "flights";
    //Flight Table Column Name
    String FLIGHTID = "FlightId";
    String FLIGHTAIRLINESID = "AirlinesId";
    String FLIGHTNUMBER = "FLightNumber";
    String FLIGHTROOTID = "RootId";
    String FLIGHTADDEDBY = "AdminId";

    //FlightSchedule TABLE
    String FLIGHTSCHEDULETABLENAME = "timeanddate";
    //FlightSchedule Table COLUMN
    String FLIGHTSCHEDULEID = "TimeAndDateId";
    String FLIGHTDEPARTUREDAY = "DepartureDay";
    String FLIGHTDEPARTURETIME = "DepartureTime";
    String FLIGHTARRIVALDAY = "ArrivalDay";
    String FLIGHTARRIVALTIME = "ArrivalTime";
    String FLIGHTSCHEDULEFLIGHTNUMBER = "FlightNumber";
    //Seat Information Table
    String SEATTABLENAME = "seatinfo";
    //COLUMN
    String FIRSTCLASS ="FirstClass";
    String BUSINESSCLASS = "BusinessClass";
    String ECONOMYCLASS = "EconomoyClass";
    String SEATOF = "FLightNumber";
    String FIRSTCLASSSEATPRICE = "FirstClassSeatPrice";
    String BUSINESSCLASSSEATPRICE = "BusinessClassSeatPrice";
    String ECONOMYCLASSSEATPRICE = "EconomyClassSeatPrice";
    
    //Transit Tabel
    String TRANSITTABLENAME = "transitinfo";
    String TRANSITOF = "FlightNumber";
    String FIRSTTRANSIT = "FirstTransit";
    String SECONDTRANSIT = "SecondTransit";

    /*
    Method For Setting connection to DATABASE
     */
    public Connection connectDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/flightreservationsystem", "root", "");
            System.out.println("Connected TO Database");

        } catch (Exception e) {
            System.out.println("Can't COnnect To Database");
        }

        return connection;
    }

    /*
    Method For InsertUserInformation
     */
    public int insertUserInformation(UserInformation user, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + USERTABLENAME + " (" + USERNAME + "," + PASSWORD + "," + FIRSTNAME + "," + LASTNAME + "," + EMAIL + "," + PHONE + "," + ADDRESS + ") VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getAddress());

            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in Inserting");
        }
        return res;
    }

    public ResultSet getUserInformationResultSet(String username, Connection connection) {
        ResultSet resultset = null;
        String query = "SELECT * FROM " + USERTABLENAME + " WHERE " + USERNAME + " = '" + username + "'";
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
            return resultset;
        } catch (Exception e) {
            System.out.println("ERROR in Fetching User Information ");
        }
        return resultset;
    }

    public ArrayList<UserInformation> getUserInformation(ResultSet resultSet) {
        ArrayList<UserInformation> list = new ArrayList();
        try {
            while (resultSet.next()) {
                UserInformation userInformation = new UserInformation();

                userInformation.setUserId(resultSet.getInt(USERID));
                userInformation.setUserName(resultSet.getString(USERNAME));
                userInformation.setFirstName(resultSet.getString(FIRSTNAME));
                userInformation.setLastName(resultSet.getString(LASTNAME));
                userInformation.setEmail(resultSet.getString(EMAIL));
                userInformation.setPassword(resultSet.getString(PASSWORD));
                userInformation.setPhone(resultSet.getString(PHONE));
                userInformation.setAddress(resultSet.getString(ADDRESS));

                list.add(userInformation);

            }

        } catch (Exception e) {
            System.out.println("Error In getting User Information");
        }
        return list;
    }

    /*
    Method For getting admin
     */
    public ResultSet getAdmin(String UserName, String Password, Connection connection) {
        String query = "SELECT * FROM " + ADMINTABLENAME + " WHERE " + ADMINUSERNAME + " = '" + UserName + "' AND " + ADMINPASSWORD + " = '" + Password + "'";
        ResultSet resultset = null;
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Admin Data");
        }
        return resultset;
    }

    /*
    Method For getting admin Information 
     */
    public ArrayList<AdminInformation> getAdminInformation(ResultSet resultSet) {
        ArrayList<AdminInformation> list = new ArrayList();
        try {
            while (resultSet.next()) {
                AdminInformation adminInformation = new AdminInformation();
                adminInformation.setAdminId(resultSet.getInt(ADMINID));
                adminInformation.setAdminUserName(resultSet.getString(ADMINUSERNAME));
                adminInformation.setAdminPassword(resultSet.getString(ADMINPASSWORD));
                adminInformation.setAdminEmail(resultSet.getString(ADMINEMAIL));
                adminInformation.setAdminFirstName(resultSet.getString(ADMINFIRSTNAME));
                adminInformation.setAdminLastName(resultSet.getString(ADMINLASTNAME));
                list.add(adminInformation);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Admin Data");
        }
        return list;
    }

    /*
     Method For Register A Airlines
     */
    public int insertAirlines(AirlinesInformation airlinesInformation, Connection connection) {
        int res = 0;
        try {

            String query = "INSERT INTO " + AIRLINESTABLENAME + " (" + AIRLINESNAME + "," + AIRLINESADMINID + "," + AIRLINESCOUNTRYNAME + "," + AIRLINESLICENSENO + ") VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, airlinesInformation.getAirlinesName());
            preparedStatement.setInt(2, airlinesInformation.getAdminId());
            preparedStatement.setString(3, airlinesInformation.getCountryName());
            preparedStatement.setString(4, airlinesInformation.getLicenseNo());

            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Registration Data");
        }

        return res;
    }

    public ResultSet getAirlines(AirlinesInformation airlinesInformation, Connection connection) {
        String query = "SELECT * FROM " + AIRLINESTABLENAME + " WHERE " + AIRLINESNAME + " = '" + airlinesInformation.getAirlinesName() + "' AND " + AIRLINESLICENSENO + " = '" + airlinesInformation.getLicenseNo() + "'";
        ResultSet resultset = null;
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airlines Inforamtion Data");
        }
        return resultset;
    }

    public ResultSet getAirlines(Connection connection) {
        String query = "SELECT * FROM " + AIRLINESTABLENAME;
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airlines Inforamtion Data");
        }
        return resultSet;
    }

    public ResultSet getAirlinesByAirlinesName(String airlinesName, Connection connection) {
        String query = "SELECT * FROM " + AIRLINESTABLENAME + " WHERE " + AIRLINESNAME + "= '" + airlinesName + "'";
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airlines Inforamtion Data");
        }
        return resultSet;
    }

    public ArrayList<AirlinesInformation> getAirlinesInformation(ResultSet resultSet) {
        ArrayList<AirlinesInformation> list = new ArrayList();
        try {
            while (resultSet.next()) {
                AirlinesInformation airlinesInformation = new AirlinesInformation();
                airlinesInformation.setAirlinesId(resultSet.getInt(AIRLINESID));
                airlinesInformation.setAirlinesName(resultSet.getString(AIRLINESNAME));
                airlinesInformation.setAdminId(resultSet.getInt(AIRLINESADMINID));
                airlinesInformation.setCountryName(resultSet.getString(AIRLINESCOUNTRYNAME));
                airlinesInformation.setLicenseNo(resultSet.getString(AIRLINESID));

                list.add(airlinesInformation);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airlines Inforamtion Data");
        }
        return list;
    }

    /*
       Method FOr Inserting a feed
     */
    public int insertFeed(Feed feed, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + FEEDSTABLENAME + " (" + FEEDADMINID + "," + FEEDEVENTS + "," + FEEDDATE + ") VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, feed.getAdminId());
            preparedStatement.setString(2, feed.getEvents());
            preparedStatement.setString(3, feed.getDate());
            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error In Inserting this Event into Database");
        }

        return res;

    }

    /*
     For getting the result set of All feeds
     */
    public ResultSet getFeedsResultSet(Connection connection) {
        ResultSet resultSet = null;
        try {
            /*
             SELECT admin.FirstName,admin.LastName,Events,Date FROM
             admin INNER JOIN Feeds ON admin.AdminId = Feeds.AdminId;
             */
            String query = "SELECT " + ADMINTABLENAME + "." + ADMINFIRSTNAME + "," + ADMINTABLENAME + "." + ADMINLASTNAME + "," + FEEDEVENTS + "," + FEEDDATE + " FROM " + ADMINTABLENAME
                    + " INNER JOIN " + FEEDSTABLENAME + " ON " + ADMINTABLENAME + "." + ADMINID + " = " + FEEDSTABLENAME + "." + FEEDADMINID;
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Feeds Result Set");
        }

        return resultSet;
    }

    public ArrayList<Feed> getFeedsList(Connection connection, ResultSet resultSet) {
        ArrayList<Feed> list = new ArrayList();
        try {
            while (resultSet.next()) {
                Feed feed = new Feed();
                feed.setFeedId(resultSet.getInt(FEEDSID));
                feed.setAdminId(resultSet.getInt(FEEDADMINID));
                feed.setEvents(resultSet.getString(FEEDEVENTS));
                feed.setDate(resultSet.getString(FEEDDATE));

                list.add(feed);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Feeds");
        }
        return list;
    }

    /*
     Registration of an Airport
     */
    public int insertAirportInformation(AirportInformation airportInformation, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + AIRPORTTABLENAME + " (" + AIRPORTNAME + "," + AIRPORTCOUNTRYNAME + "," + AIRPORTCITYNAME + "," + AIRPORTCODE + "," + AIRPORTADDEDBY + ") VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, airportInformation.getAirportName());
            preparedStatement.setString(2, airportInformation.getCountryName());
            preparedStatement.setString(3, airportInformation.getCityName());
            preparedStatement.setString(4, airportInformation.getAirportCode());
            preparedStatement.setInt(5, airportInformation.getAdminId());
            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error In Inserting this Airport into Database");
        }

        return res;
    }

    public ResultSet getAirportResultSet(Connection connection, AirportInformation airportInformation) {
        ResultSet resultSet = null;
        try {
            /*
             SELECT admin.FirstName,admin.LastName,Events,Date FROM
             admin INNER JOIN Feeds ON admin.AdminId = Feeds.AdminId;
             */
            String query = "SELECT * FROM " + AIRPORTTABLENAME + " WHERE " + AIRPORTNAME + " = '" + airportInformation.getAirportName()
                    + "' AND " + AIRPORTCOUNTRYNAME + " = '" + airportInformation.getCountryName() + "' AND " + AIRPORTCODE + " = '" + airportInformation.getAirportCode() + "'";
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airport Result Set");
        }

        return resultSet;
    }

    public ResultSet getAirportResultSet(Connection connection) {
        ResultSet resultset = null;
        String query = "SELECT * FROM " + AIRPORTTABLENAME;
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
            return resultset;
        } catch (Exception e) {
            System.out.println("ERROR in Fetching  Information ");
        }
        return resultset;
    }

    public ResultSet getAirportResultSetByCityName(Connection connection, String city) {
        ResultSet resultset = null;
        String query = "SELECT * FROM " + AIRPORTTABLENAME + " WHERE " + AIRPORTCITYNAME + " = '" + city + "'";
        //System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
            return resultset;
        } catch (Exception e) {
            System.out.println("ERROR in Fetching  Information ");
        }
        return resultset;
    }

    public ResultSet getAirportResultSetByAirportName(Connection connection, String AirportName) {
        ResultSet resultset = null;
        String query = "SELECT * FROM " + AIRPORTTABLENAME + " WHERE " + AIRPORTNAME + " = '" + AirportName + "'";
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
            return resultset;
        } catch (Exception e) {
            System.out.println("ERROR in Fetching  Information ");
        }
        return resultset;
    }

    public ArrayList<AirportInformation> getAirportInformationList(ResultSet resultSet) {
        ArrayList<AirportInformation> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                AirportInformation airportInformation = new AirportInformation();
                airportInformation.setAirportId(resultSet.getInt(AIRPORTID));
                airportInformation.setAirportName(resultSet.getString(AIRPORTNAME));
                airportInformation.setCountryName(resultSet.getString(AIRPORTCOUNTRYNAME));
                airportInformation.setCityName(resultSet.getString(AIRPORTCITYNAME));
                airportInformation.setAirportCode(resultSet.getString(AIRPORTCODE));

                list.add(airportInformation);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airport Information");
        }

        return list;
    }

    public ResultSet getAllAirportInformationResultSet(String Place, Connection connection) {
        ResultSet resultSet = null;
        try {
            /*
             SELECT admin.FirstName,admin.LastName,Events,Date FROM
             admin INNER JOIN Feeds ON admin.AdminId = Feeds.AdminId;
             */
            String query = "SELECT * FROM " + AIRPORTTABLENAME + " WHERE " + AIRPORTCITYNAME + " = '" + Place + "'";

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Airport Result Set");
        }

        return resultSet;
    }

    public int insertRootInformation(RootInformation root, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + ROOTTABLENAME + " (" + ROOTDEPARTURECITYAIRPORTCODE + "," + ROOTDESTINATIONCITYAIRPORTCODE + "," + ROOTADDEDBY + ") VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, root.getDepartureCityAirportCode());
            preparedStatement.setString(2, root.getDestinationCityAirporCode());
            preparedStatement.setInt(3, root.getAddedBy());

            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Inserting this Root");
        }
        return res;
    }

    public ResultSet getAllRootInformationResultSet(RootInformation rootInformation, Connection connection) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM " + ROOTTABLENAME + " WHERE " + ROOTDEPARTURECITYAIRPORTCODE + " = '" + rootInformation.getDepartureCityAirportCode() + "' AND "
                    + ROOTDESTINATIONCITYAIRPORTCODE + " = '" + rootInformation.getDestinationCityAirporCode() + "'";
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Root Information Result Set");
        }

        return resultSet;
    }

    public ResultSet getRootIdByAirportCode(String departureAirportCode, String destinationAirportCode, Connection connection) {
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM " + ROOTTABLENAME + " WHERE " + ROOTDEPARTURECITYAIRPORTCODE + "= '" + departureAirportCode + "' AND " + ROOTDESTINATIONCITYAIRPORTCODE + " = '" + destinationAirportCode + "'";
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Root Information Result Set");
        }

        return resultSet;
    }

    public ArrayList<RootInformation> getALlRootInformationList(ResultSet resultSet) {
        ArrayList<RootInformation> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                RootInformation rootInformation = new RootInformation();
                rootInformation.setRootId(resultSet.getInt(ROOTID));
                rootInformation.setDepartureCityAirportCode(resultSet.getString(ROOTDEPARTURECITYAIRPORTCODE));
                rootInformation.setDestinationCityAirporCode(resultSet.getString(ROOTDESTINATIONCITYAIRPORTCODE));
                rootInformation.setAddedBy(resultSet.getInt(ROOTADDEDBY));

                list.add(rootInformation);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching ROOT Information");
        }

        return list;
    }

    public ResultSet getFlightInformationByFlightNumber(String flightNumber, Connection connection) {
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM " + FLIGHTTABLENAME + " WHERE " + FLIGHTNUMBER + " = '" + flightNumber + "'";
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Flight Information");
        }

        return resultSet;
    }

    public ArrayList<FlightInformation> getFlightInformationList(ResultSet resultSet) {
        ArrayList<FlightInformation> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                FlightInformation flightInformation = new FlightInformation();
                flightInformation.setFlightid(resultSet.getInt(FLIGHTID));
                flightInformation.setAirlinesId(resultSet.getInt(FLIGHTAIRLINESID));
                flightInformation.setFlightNumber(resultSet.getString(FLIGHTNUMBER));
                flightInformation.setRootId(resultSet.getInt(FLIGHTROOTID));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Fetching Flight Information");
        }
        return list;
    }

    public int insertFlight(FlightInformation flightInformation, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + FLIGHTTABLENAME + " (" + FLIGHTAIRLINESID + "," + FLIGHTNUMBER + "," + FLIGHTROOTID + "," + FLIGHTADDEDBY + ") VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, flightInformation.getAirlinesId());
            preparedStatement.setString(2, flightInformation.getFlightNumber());
            preparedStatement.setInt(3, flightInformation.getRootId());
            preparedStatement.setInt(4, flightInformation.getAdminId());

            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Inserting Flight Information");
        }

        return res;
    }

    public int insertFlightSchedule(FlightSchedule flightSchedule, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + FLIGHTSCHEDULETABLENAME + " (" + FLIGHTDEPARTUREDAY + "," + FLIGHTDEPARTURETIME + "," + FLIGHTARRIVALDAY + "," + FLIGHTARRIVALTIME + "," + FLIGHTSCHEDULEFLIGHTNUMBER + ") VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, flightSchedule.getDepartureDay());
            preparedStatement.setString(2, flightSchedule.getDepartureTime());
            preparedStatement.setString(3, flightSchedule.getArrivalDay());
            preparedStatement.setString(4, flightSchedule.getArrivalTIme());
            preparedStatement.setString(5, flightSchedule.getFlightNumber());

            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Inserting Flight Schedule Information");
        }

        return res;
    }

     public int insertSeatInfo(SeatInfo seatInformation, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + SEATTABLENAME + " (" + FIRSTCLASS + "," + BUSINESSCLASS + "," + ECONOMYCLASS + ","+FIRSTCLASSSEATPRICE+","+BUSINESSCLASSSEATPRICE+","+ECONOMYCLASSSEATPRICE+","+SEATOF+ ") VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, seatInformation.getFirstclassAmount());
            preparedStatement.setInt(2, seatInformation.getBusinessClassAmount());
            preparedStatement.setInt(3, seatInformation.getEconomyClassAmount());
            preparedStatement.setInt(4, seatInformation.getFirstclassseatprice());
            preparedStatement.setInt(5, seatInformation.getBusinessclassseatprice());
            preparedStatement.setInt(6, seatInformation.getEconomyclassseatprice());
            preparedStatement.setString(7, seatInformation.getFlightNumber());

            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error In Inserting Flight Schedule Information");
        }

        return res;
    }
     public int insertTransit(FlightTransit flightTransit, Connection connection) {
        int res = 0;
        try {
            String query = "INSERT INTO " + TRANSITTABLENAME + " (" + TRANSITOF + "," + FIRSTTRANSIT + "," + SECONDTRANSIT + ") VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, flightTransit.getFlightNumber());
            preparedStatement.setString(2, flightTransit.getFirstTransit());
            preparedStatement.setString(3, null);
          
            res = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error In Inserting Transit Information");
        }

        return res;
    }
     
}
