#include <iostream>
#include <fstream>
#include <vector>
#include <stdlib.h>
#include <iomanip>
#include <algorithm>
#include <string>
#include <ctype.h>
#include <sstream>
using namespace std;

int main(){
        fstream fin, fout;
        fin.open("sales.csv", ios::in);
        fout.open("output.csv", ios::out);
        int prod[6][8], ans = 0, x = 0, y = 1;
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 8; j++)
                prod[i][j] = 500 + rand() % 9501;
        string word, temp;
        vector<string> row;
        fout << ".......................04.08.2022.......................\n";
        while(!fin.eof()){
                if(x % 6 == 0){
                	if(ans && y - 1 < 5)
                        	fout << "Total sale at Region " << y - 1 << " Rs. " << ans << "/-" << "\n";
                        ans = 0;
                        if(y < 5)
                        	fout << "Region" << y << "\n";
                        y++;
                        x = 0;
                }
                row.clear();
                getline(fin, temp);
                stringstream s(temp);
                while(getline(s, word, ','))
                        row.push_back(word);
                if(!fin.eof()){
                        int a =  atoi(row[3].c_str());
                        int b = atoi(row[2].c_str());
                        int c = atoi(row[1].c_str());
                        int p = a * prod[b - 1][c - 1];
                        fout << "Salesman " << (x + 1) % 7 << " Rs. " << p << "/-" << "\n";
                        ans += p;
			x++;
                }
        }
        fin.close();
        fout.close();
        return 0;
}
