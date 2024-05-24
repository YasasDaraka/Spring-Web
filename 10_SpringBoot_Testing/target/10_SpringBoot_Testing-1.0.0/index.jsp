<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/8/2023
  Time: 7:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Management</title>
    <!-- Include Bootstrap CSS with the dark theme -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS for the dark theme -->
    <style>
        body {
            background-color: #03001C; /* Dark background color */
            color: #5B8FB9; /* Light text color */
        }

        /* Apply dark styles to the form */
        .form-control {
            background-color: #18122B; /* Dark form input background color */
            color: #B6EADA; /* Light text color for form inputs */
        }

        /* Apply dark styles to the table */
        .table {
            background-color: #03001C; /* Dark table background color */
            color: #B6EADA; /* Light text color for table content */
        }

        /* Override table header styles to make it lighter */
        .table thead {
            background-color: #18122B; /* Darker header background color */
        }

        /* Apply styles to the search bar */
        .form-group {
            margin-top: 20px; /* Add some spacing */
        }

        #searchInput {
            background-color: #18122B;
            color: #B6EADA;
            border: none;
            border-radius: 4px;
            padding: 10px;
            width: 70%;
            margin-right: 10px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2>Customer Management</h2>

    <div class="row">
        <!-- Customer Form Column -->
        <div class="col-md-6">
            <form id="customerForm">
                <div class="form-group">
                    <label for="txtCustomerID">Customer ID:</label>
                    <input type="text" class="form-control" id="txtCustomerID" name="id" required>
                </div>
                <div class="form-group">
                    <label for="txtCustomerName">Customer Name:</label>
                    <input type="text" class="form-control" id="txtCustomerName" name="name" required>
                </div>
                <div class="form-group">
                    <label for="txtCustomerAddress">Customer Address:</label>
                    <input type="text" class="form-control" id="txtCustomerAddress" name="address" required>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-dark" id="btnCustomer">Save Customer</button>
                    <button type="button" class="btn btn-dark" id="btnCusDelete">Remove</button>
                    <button type="button" class="btn btn-dark" id="btnUpdate">Update</button>
                    <button type="button" class="btn btn-dark" id="btnGetAll">Get All</button>
                    <button type="button" class="btn btn-dark" id="btnClear">Clear All</button>
                </div>
            </form>
        </div>

        <!-- Customer Table Column -->
        <div class="col-md-6">
            <div class="form-group">
                <!-- Add a search bar -->
                <input type="text" id="searchInput" placeholder="Search customers by id">
                <button type="button" class="btn btn-dark" id="searchById">Search</button>
            </div>

            <table class="table">
                <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Customer Name</th>
                    <th>Customer Address</th>
                </tr>
                </thead>
                <tbody id="tblCustomer">
                <!-- Customer data will be displayed here -->
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Include Bootstrap JS and jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>

    let baseUrl = 'http://localhost:8080/app/';

    getAllCustomers();
    bindRowClickEvents();

    // get all
    $("#btnGetAll").click(function () {
        getAllCustomers();
    });

    function getAllCustomers() {
        $("#tblCustomer").empty();

        $.ajax({
            url: baseUrl + 'customer',
            method: "GET",
            success: function (response) {
                console.log(response);
                let customers = response.data;
                for (let i in customers) {
                    let cus = customers[i];
                    let id = cus.id;
                    let name = cus.name;
                    let address = cus.address;
                    let row = "<tr><td>" + id + "</td><td>" + name + "</td><td>" + address + "</td></tr>";
                    $("#tblCustomer").append(row);
                }
                setTextFields("", "", "");
            },
            error: function (error) {
                console.log(error);
                alert(error.responseJSON.message);
                setTextFields("", "", "");
            }
        });
    }

    // find
    $("#searchById").click(function () {
        $("#tblCustomer").empty();
        let id = $('#searchInput').val();

        $.ajax({
            url: baseUrl + 'customer?id=' + id,
            method: "GET",
            success: function (response) {
                console.log(response);
                let customer = response.data;
                let id = customer.id;
                let name = customer.name;
                let address = customer.address;
                let row = "<tr><td>" + id + "</td><td>" + name + "</td><td>" + address + "</td></tr>";
                $("#tblCustomer").append(row);
                $('#searchInput').val("");
            },
            error: function (error) {
                console.log(error);
                alert(error.responseJSON.message);
                setTextFields("", "", "");
                $('#searchInput').val("");
                getAllCustomers();
            }
        });
    });

    // bind table row values to text field on click
    function bindRowClickEvents() {
        $('#tblCustomer').on('click', 'tr', function () {
            let id = $(this).find('td:eq(0)').text();
            let name = $(this).find('td:eq(1)').text();
            let address = $(this).find('td:eq(2)').text();

            setTextFields(id, name, address);
        });
    }

    // set text fields
    function setTextFields(id, name, address) {
        $('#txtCustomerID').val(id);
        $('#txtCustomerName').val(name);
        $('#txtCustomerAddress').val(address);
    }

    $("#btnClear").click(function () {
        setTextFields("", "", "");
    });

    // add
    $("#btnCustomer").click(function () {
        let formData = $("#customerForm").serialize();
        $.ajax({
            url: baseUrl + 'customer',
            method: "POST",
            data: formData,
            success: function (response) {
                console.log(response);
                alert(response.message);
                getAllCustomers();
            },
            error: function (error) {
                console.log(error);
                alert(error.responseJSON.message);
            }
        });
    });

    // update
    $("#btnUpdate").click(function () {
        let id = $('#txtCustomerID').val();
        let name = $('#txtCustomerName').val();
        let address = $('#txtCustomerAddress').val();

        let customer = {
            "id": id,
            "name": name,
            "address": address
        }

        let b = confirm("Do you want to Update " + id + " ?");

        if (b) {
            $.ajax({
                url: baseUrl + 'customer',
                method: 'PUT',
                contentType: "application/json",
                data: JSON.stringify(customer),

                success: function (response) {
                    console.log(response);
                    alert(response.message);
                    getAllCustomers();
                },
                error: function (error) {
                    console.log(error);
                    alert(error.responseJSON.message);
                }
            });
        }
    });

    // delete
    $("#btnCusDelete").click(function () {
        let id = $('#txtCustomerID').val();

        let b = confirm("Do you want to Delete " + id + " ?");
        if (b) {
            $.ajax({
                url: baseUrl + 'customer?id=' + id,
                method: 'DELETE',

                success: function (response) {
                    console.log(response);
                    alert(response.message);
                    getAllCustomers();
                },
                error: function (error) {
                    console.log(error);
                    alert(error.responseJSON.message);
                }
            });
        }
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>