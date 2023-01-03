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
vector<vector<string>> helper(vector<string> res)
{
    vector<vector<string>> ans;
    for (int i = 0; i < res.size(); i++)
    {
        vector<string> tempo;
        int k;
        cout << "Enter Price of " << product_code(res[i]) << " : ";
        cin >> k;
        tempo.push_back(res[i]);
        tempo.push_back(to_string(k));
        ans.push_back(tempo);
    }
    return ans;
}
int main()
{
    ifstream file;
    file.open("temp.txt");
    string resStr;
    vector<string> myStr;
    while (getline(file, resStr))
    {
        // cout<<resStr<<endl;
        myStr.push_back(resStr);
    }
    // unordered_map<string,int>m;
    vector<vector<string>> ans = helper(myStr);
    for (int i = 0; i < ans.size(); i++)
    {
        for (int j = 0; j < ans[i].size(); j++)
        {
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    file.close();
    // fstream final_file;
    // final_file.open("answer.txt",ios::out|ios::app);
    ofstream final_file;
    final_file.open("answer.txt");
    for (int i = 0; i < ans.size(); i++)
    {
        string f = ans[i][0];
        string l = ans[i][1];
        final_file << f << "|" << l << endl;
    }

    final_file.close();
    ofstream report;
    report.open("Report.txt");
    
    return 0;
}