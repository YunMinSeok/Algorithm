#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>
using namespace std;

int alpha[26 + 1];

bool cmp(int a, int b) {
	if (a > b) {
		return true;
	}
	else {
		return false;
	}
}

int main() {
	int n;
	cin >> n;

	while (n--) {
		string s;
		cin >> s;

		int size = s.size();
		for (int i = 0; i < size; ++i) {
			alpha[s[i] - 65] += pow(10, size - i - 1);
		}
		
	}
    sort(alpha, alpha + 26, cmp);
	int sum = 0;
    
	int nine = 9;
	for (int i = 0; i < 26; ++i) {
		if (alpha[i] == 0) {
			cout << sum << endl;
			return 0;
		}
		else {
			sum += alpha[i] * nine;
			nine--;
		}
	}
}
