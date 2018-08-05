using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TravelFrontEnd.Models;

namespace TravelFrontEnd.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
 
        public IActionResult login()
        {
            return View();
        }

        public IActionResult adminProfile()
        {
            return View();
        }

        public IActionResult eventmanagerProfile()
        {
            return View();
        }

        public IActionResult profile()
        {
            return View();
        }

        public IActionResult userProfile()
        {
            return View();
        }

        public IActionResult ownerProfile()
        {
            return View();
        }

        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
