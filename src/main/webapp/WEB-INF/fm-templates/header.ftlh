<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="media">
        <a href="main-page"><img src="/HTML/morswin.png" height="80" width="80" class="mr-3" alt="..."></a>
    </div>
    <a class="navbar-brand" href="#"><b>Morświny Events</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="search-events?search=">Events</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/HTML/log-in.html">My Account</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/add-event">Add Event</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Filter
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="my-profile.html">Filter by Date</a>
                    <a class="dropdown-item" href="my-profile.html">Filter by Place</a>
                    <a class="dropdown-item" href="my-profile.html">Filter by Ticket Price</a>
                </div>
            </li>
            <li class="nav-item active">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/contact">Contact</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/HTML/abous-us.html">About Us</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/search-events?">
            <input class="form-control mr-sm-2" type="search" placeholder="Type here..." name = "search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div>
            <a href="/HTML/log-in.html">
                <button type="button" style="position:relative; right:-5px;" class="btn btn-outline-primary">Log in
                </button>
            </a>
        </div>

    </div>
</nav>
