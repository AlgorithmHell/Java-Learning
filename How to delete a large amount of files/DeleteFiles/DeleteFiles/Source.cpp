#include <iostream>
#include <windows.h>
#include "Windows.h"
#include <string>
using namespace std;
int main()
{
	WIN32_FIND_DATA FolderOrigin, FolderToBeEdited, BoxToBeKept;
	HANDLE Origin, ToBeEdited, Box;
	Origin = FindFirstFile(L"origin\\*", &FolderOrigin);
	ToBeEdited = FindFirstFile(L"to be edited\\*", &FolderToBeEdited);//this is for jpg
	FindNextFile(ToBeEdited, &FolderToBeEdited);
	Box = FindFirstFile(L"to be edited\\*", &BoxToBeKept);//this is for boxes
	bool FolderHasNext = 0;
	if (Origin != INVALID_HANDLE_VALUE)
	{
		do
		{
			wstring box, jpg;
			wcout << FolderOrigin.cFileName << ends << FolderToBeEdited.cFileName << endl;
			if (FolderOrigin.cFileName != FolderToBeEdited.cFileName)
			{
				 box = FolderToBeEdited.cFileName;
				 jpg = FolderOrigin.cFileName;
				FolderHasNext = FindNextFile(Origin, &FolderOrigin);
				if (FolderHasNext != 0)
				{
					FindNextFile(ToBeEdited, &FolderToBeEdited);
					FindNextFile(ToBeEdited, &FolderToBeEdited);
					FindNextFile(Box, &BoxToBeKept);
					FindNextFile(Box, &BoxToBeKept);
				}
				wcout<<DeleteFileW(jpg.c_str())<<ends;//delete jpg
				wcout<<DeleteFileW(box.c_str())<<endl;//delete box

				if (FolderHasNext == 0) break;

			}
			else
			{
				FolderHasNext = FindNextFile(Origin, &FolderOrigin);
				if (FolderHasNext == 0) break;
				FindNextFile(ToBeEdited, &FolderToBeEdited);
				FindNextFile(ToBeEdited, &FolderToBeEdited);
				FindNextFile(Box, &BoxToBeKept);
				FindNextFile(Box, &BoxToBeKept);
			}

		} while (true);
	}


	return 0;
}
