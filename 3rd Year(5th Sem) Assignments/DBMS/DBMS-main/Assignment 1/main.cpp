#include <bits/stdc++.h>
#include <fstream>
using namespace std;

string product_code(string res)
{
    int count = 0;
    string temp;
    for (int i = 0; i < res.length(); i++)
    {
        if (res[i] == ' ')
        {
            count++;
        }
        if (count == 2)
        {
            temp.push_back(res[i]);
        }
    }
    return temp;
}
vector<vector<string>> helper(vector<string> res, unordered_map<string, int> &m)
{
    unordered_set<string> unique_product; 
    vector<vector<string>> ans;
    for (int i = 0; i < res.size(); i++)
    {
        if (unique_product.find(product_code(res[i])) != unique_product.end())
            continue;
        else
        {
            vector<string> tempo;
            int k;
            cout << "Enter Price of " << product_code(res[i]) << " : ";
            cin >> k;
            tempo.push_back(res[i]);
            tempo.push_back(to_string(k));
            m[product_code(res[i])] = k;
            ans.push_back(tempo);
            unique_product.insert(product_code(res[i]));
        }
    }
    return ans;
}

// Function used for extracting region form the vector of string
vector<string> regionExtraction(vector<string> myStr, int reg)
{
    vector<string> vec;
    for (int i = 0; i < myStr.size(); i++)
    {
        if (myStr[i][0] - '0' == reg)
            vec.push_back(myStr[i]);
    }
    return vec;
}

// Function for Extraction of Salesman from the vector of string
unordered_map<int, vector<string>> salesmanExtraction(vector<string> myStr)
{
    unordered_map<int, vector<string>> m;
    for (int i = 0; i < myStr.size(); i++)
    {
        m[myStr[i][2] - '0'].push_back(myStr[i]);
    }
    return m;
}

int getNumber(string str)
{
    int count = 0;
    string res;
    for (int i = 0; i < str.length(); i++)
    {
        if (str[i] == ' ')
            count++;
        if (count == 3)
        {
            res.push_back(str[i]);
        }
    }
    return stoi(res);
}
int calculateTotal(vector<string> myStr, unordered_map<string, int> m)
{
    int total = 0;
    for (int i = 0; i < myStr.size(); i++)
    {
        total += m[product_code(myStr[i])] * getNumber(myStr[i]);
    }
    return total;
}

int main()
{
    ifstream file;
    file.open("temp.txt");
    string resStr;
    vector<string> myStr;
    while (getline(file, resStr))
    {
        myStr.push_back(resStr);
    }
    unordered_map<string, int> price;

    vector<vector<string>> ans = helper(myStr, price);

    /*
    for (int i = 0; i < ans.size(); i++)
    {
        for (int j = 0; j < ans[i].size(); j++)
        {
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    */
    file.close();
    ofstream final_file;
    final_file.open("answer.txt");
    for (int i = 0; i < ans.size(); i++)
    {
        string f = ans[i][0];
        string l = ans[i][1];
        final_file << f << "|" << l << endl;
    }
    ofstream f_file;
    f_file.open("Report.txt");
    f_file << "\t\t\t Indranil Bain\t\t" << endl;
    f_file << "\t\t\t2020CSB039" << endl;

    f_file << "\t\tReport for Salesman for Each Region" << endl;
    for (int i = 1; i <= 4; i++)
    {
        f_file << "\n\t\t\tRegion : " << i << endl
               << endl;
        vector<string> vec = regionExtraction(myStr, i);
        // f_file<<getNumber(myStr[i])<<endl;
        for (int j = 1; j < 7; j++)
        {
            unordered_map<int, vector<string>> salesMan = salesmanExtraction(vec);
            f_file << "Sales Man " << j << " : " << calculateTotal(salesMan[j], price) << endl;
        }
        f_file << "Total Sale in Region " << i << " is: " << calculateTotal(vec, price) << endl;
    }
    f_file.close();
    final_file.close();
    return 0;
}
