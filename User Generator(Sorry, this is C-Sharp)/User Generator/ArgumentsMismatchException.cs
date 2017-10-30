using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace User_Generator
{
    class ArgumentsMismatchException : Exception
    {
        private String message;
        public ArgumentsMismatchException(String argsLength)
        {
            message = argsLength;
        }
        
        public override String Message
        { get
            {
                return message;
            }
        }
         

            



        
    }
}
