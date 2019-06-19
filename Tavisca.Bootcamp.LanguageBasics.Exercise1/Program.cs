using System;

namespace Tavisca.Bootcamp.LanguageBasics.Exercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            Test("42*47=1?74", 9);
            Test("4?*47=1974", 2);
            Test("42*?7=1974", 4);
            Test("42*?47=1974", -1);
            Test("2*12?=247", -1);
            Console.ReadKey(true);
        }

        private static void Test(string args, int expected)
        {
            var result = FindDigit(args).Equals(expected) ? "PASS" : "FAIL";
            Console.WriteLine($"{args} : {result}");
        }

        public static int FindDigit(string equation)
        {
            // Add your code here.
            //throw new NotImplementedException();
            string firstArg = equation.Split('*')[0];
            string secondArg = equation.Split('*')[1].Split('=')[0];
            string result = equation.Split('=')[1];
			float finalResult = -1;
			string givenResult = string.Empty;
			string temporary = string.Empty;

            //setting up finalResult which is calculated by the given 2 arguements
            //setting the value of givenArgument for which the corresponding value is to be found.
			if(firstArg.Contains("?")){
				finalResult = ((float)Int32.Parse(result))/Int32.Parse(secondArg);
				givenResult += firstArg;
			}
			else if(secondArg.Contains("?")){
				finalResult = ((float)Int32.Parse(result))/Int32.Parse(firstArg);	
				givenResult += secondArg;
			}
			else if(result.Contains("?")){
				finalResult = Int32.Parse(firstArg)*Int32.Parse(secondArg);
				givenResult = result;
			}
			
			if(finalResult != (int)finalResult){
                //if finalResult(desired number) has no integer solution
				return -1;
			}
			
            //temporary is the string format of the Final Result which should be the answer
			temporary += finalResult.ToString();
			
            //Condition to check whether an integral solution is possible or not
			if(temporary.Length != givenResult.Length){
                //If no integer solution possible then return -1
				return -1;
			}
			else{
				for(int i = 0; i < temporary.Length; i++){
					if(temporary[i] != givenResult[i] && givenResult[i] == '?'){
                        //Condition to check whether the current index is the required index
                        //returning the integer value of current character
						return (int)(temporary[i] - 48);
					}
					else if(temporary[i] != givenResult[i] && givenResult[i] != '?'){
                        //If mismatch occurs in the integer values of two string, means results are not same
                        //returning -1 
						return -1;
					}
				}
			}
			return -1;
        }
    }
}
