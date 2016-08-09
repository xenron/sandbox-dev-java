package tuning.loop;

public class ConvertTest
{
	/*
convert  - original
convert1 - map instead of char cast on int
convert2 - map instead of char cast on int+256
convert3 - map instead of char cast & 'if' statement
convert4 - as convert3, but fold in temporary variable
convert5 - use map of num to add to byte instead of 'if' statement
convert6 - as convert4, but using int array for MAP instead of char array, & casting
convert7 - as convert4, but without other 'if' statement
convert8 - as convert6, but without other 'if' statement

	*/

	public static final char[] MAP1 = {
		(char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9,
		(char) 10, (char) 11, (char) 12, (char) 13, (char) 14, (char) 15, (char) 16, (char) 17, (char) 18, (char) 19,
		(char) 20, (char) 21, (char) 22, (char) 23, (char) 24, (char) 25, (char) 26, (char) 27, (char) 28, (char) 29,
		(char) 30, (char) 31, (char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39,
		(char) 40, (char) 41, (char) 42, (char) 43, (char) 44, (char) 45, (char) 46, (char) 47, (char) 48, (char) 49,
		(char) 50, (char) 51, (char) 52, (char) 53, (char) 54, (char) 55, (char) 56, (char) 57, (char) 58, (char) 59,
		(char) 60, (char) 61, (char) 62, (char) 63, (char) 64, (char) 65, (char) 66, (char) 67, (char) 68, (char) 69,
		(char) 70, (char) 71, (char) 72, (char) 73, (char) 74, (char) 75, (char) 76, (char) 77, (char) 78, (char) 79,
		(char) 80, (char) 81, (char) 82, (char) 83, (char) 84, (char) 85, (char) 86, (char) 87, (char) 88, (char) 89,
		(char) 90, (char) 91, (char) 92, (char) 93, (char) 94, (char) 95, (char) 96, (char) 97, (char) 98, (char) 99,
		(char) 100, (char) 101, (char) 102, (char) 103, (char) 104, (char) 105, (char) 106, (char) 107, (char) 108, (char) 109,
		(char) 110, (char) 111, (char) 112, (char) 113, (char) 114, (char) 115, (char) 116, (char) 117, (char) 118, (char) 119,
		(char) 120, (char) 121, (char) 122, (char) 123, (char) 124, (char) 125, (char) 126, (char) 127
	};

	public static final char[] MAP2 = {
		(char) 256-128, (char) 256-127, (char) 256-126, (char) 256-125, (char) 256-124, (char) 256-123, (char) 256-122, (char) 256-121, (char) 256-120,
		(char) 256-119, (char) 256-118, (char) 256-117, (char) 256-116, (char) 256-115, (char) 256-114, (char) 256-113, (char) 256-112, (char) 256-111, (char) 256-110,
		(char) 256-109, (char) 256-108, (char) 256-107, (char) 256-106, (char) 256-105, (char) 256-104, (char) 256-103, (char) 256-102, (char) 256-101, (char) 256-100,
		(char) 256-99, (char) 256-98, (char) 256-97, (char) 256-96, (char) 256-95, (char) 256-94, (char) 256-93, (char) 256-92, (char) 256-91, (char) 256-90,
		(char) 256-89, (char) 256-88, (char) 256-87, (char) 256-86, (char) 256-85, (char) 256-84, (char) 256-83, (char) 256-82, (char) 256-81, (char) 256-80,
		(char) 256-79, (char) 256-78, (char) 256-77, (char) 256-76, (char) 256-75, (char) 256-74, (char) 256-73, (char) 256-72, (char) 256-71, (char) 256-70,
		(char) 256-69, (char) 256-68, (char) 256-67, (char) 256-66, (char) 256-65, (char) 256-64, (char) 256-63, (char) 256-62, (char) 256-61, (char) 256-60,
		(char) 256-59, (char) 256-58, (char) 256-57, (char) 256-56, (char) 256-55, (char) 256-54, (char) 256-53, (char) 256-52, (char) 256-51, (char) 256-50,
		(char) 256-49, (char) 256-48, (char) 256-47, (char) 256-46, (char) 256-45, (char) 256-44, (char) 256-43, (char) 256-42, (char) 256-41, (char) 256-40,
		(char) 256-39, (char) 256-38, (char) 256-37, (char) 256-36, (char) 256-35, (char) 256-34, (char) 256-33, (char) 256-32, (char) 256-31, (char) 256-30,
		(char) 256-29, (char) 256-28, (char) 256-27, (char) 256-26, (char) 256-25, (char) 256-24, (char) 256-23, (char) 256-22, (char) 256-21, (char) 256-20,
		(char) 256-19, (char) 256-18, (char) 256-17, (char) 256-16, (char) 256-15, (char) 256-14, (char) 256-13, (char) 256-12, (char) 256-11, (char) 256-10,
		(char) 256-9, (char) 256-8, (char) 256-7, (char) 256-6, (char) 256-5, (char) 256-4, (char) 256-3, (char) 256-2, (char) 256-1,
	};

	public static final char[] MAP3 = {
		(char) 256-128, (char) 256-127, (char) 256-126, (char) 256-125, (char) 256-124, (char) 256-123, (char) 256-122, (char) 256-121, (char) 256-120,
		(char) 256-119, (char) 256-118, (char) 256-117, (char) 256-116, (char) 256-115, (char) 256-114, (char) 256-113, (char) 256-112, (char) 256-111, (char) 256-110,
		(char) 256-109, (char) 256-108, (char) 256-107, (char) 256-106, (char) 256-105, (char) 256-104, (char) 256-103, (char) 256-102, (char) 256-101, (char) 256-100,
		(char) 256-99, (char) 256-98, (char) 256-97, (char) 256-96, (char) 256-95, (char) 256-94, (char) 256-93, (char) 256-92, (char) 256-91, (char) 256-90,
		(char) 256-89, (char) 256-88, (char) 256-87, (char) 256-86, (char) 256-85, (char) 256-84, (char) 256-83, (char) 256-82, (char) 256-81, (char) 256-80,
		(char) 256-79, (char) 256-78, (char) 256-77, (char) 256-76, (char) 256-75, (char) 256-74, (char) 256-73, (char) 256-72, (char) 256-71, (char) 256-70,
		(char) 256-69, (char) 256-68, (char) 256-67, (char) 256-66, (char) 256-65, (char) 256-64, (char) 256-63, (char) 256-62, (char) 256-61, (char) 256-60,
		(char) 256-59, (char) 256-58, (char) 256-57, (char) 256-56, (char) 256-55, (char) 256-54, (char) 256-53, (char) 256-52, (char) 256-51, (char) 256-50,
		(char) 256-49, (char) 256-48, (char) 256-47, (char) 256-46, (char) 256-45, (char) 256-44, (char) 256-43, (char) 256-42, (char) 256-41, (char) 256-40,
		(char) 256-39, (char) 256-38, (char) 256-37, (char) 256-36, (char) 256-35, (char) 256-34, (char) 256-33, (char) 256-32, (char) 256-31, (char) 256-30,
		(char) 256-29, (char) 256-28, (char) 256-27, (char) 256-26, (char) 256-25, (char) 256-24, (char) 256-23, (char) 256-22, (char) 256-21, (char) 256-20,
		(char) 256-19, (char) 256-18, (char) 256-17, (char) 256-16, (char) 256-15, (char) 256-14, (char) 256-13, (char) 256-12, (char) 256-11, (char) 256-10,
		(char) 256-9, (char) 256-8, (char) 256-7, (char) 256-6, (char) 256-5, (char) 256-4, (char) 256-3, (char) 256-2, (char) 256-1,
		(char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9,
		(char) 10, (char) 11, (char) 12, (char) 13, (char) 14, (char) 15, (char) 16, (char) 17, (char) 18, (char) 19,
		(char) 20, (char) 21, (char) 22, (char) 23, (char) 24, (char) 25, (char) 26, (char) 27, (char) 28, (char) 29,
		(char) 30, (char) 31, (char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39,
		(char) 40, (char) 41, (char) 42, (char) 43, (char) 44, (char) 45, (char) 46, (char) 47, (char) 48, (char) 49,
		(char) 50, (char) 51, (char) 52, (char) 53, (char) 54, (char) 55, (char) 56, (char) 57, (char) 58, (char) 59,
		(char) 60, (char) 61, (char) 62, (char) 63, (char) 64, (char) 65, (char) 66, (char) 67, (char) 68, (char) 69,
		(char) 70, (char) 71, (char) 72, (char) 73, (char) 74, (char) 75, (char) 76, (char) 77, (char) 78, (char) 79,
		(char) 80, (char) 81, (char) 82, (char) 83, (char) 84, (char) 85, (char) 86, (char) 87, (char) 88, (char) 89,
		(char) 90, (char) 91, (char) 92, (char) 93, (char) 94, (char) 95, (char) 96, (char) 97, (char) 98, (char) 99,
		(char) 100, (char) 101, (char) 102, (char) 103, (char) 104, (char) 105, (char) 106, (char) 107, (char) 108, (char) 109,
		(char) 110, (char) 111, (char) 112, (char) 113, (char) 114, (char) 115, (char) 116, (char) 117, (char) 118, (char) 119,
		(char) 120, (char) 121, (char) 122, (char) 123, (char) 124, (char) 125, (char) 126, (char) 127
	};

	public static final int[] MAP4 = {
		256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,256,
		256,256,256,256,256,256,256,256,256,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0
	};

	public static final int[] MAP5 = {
		256-128, 256-127, 256-126, 256-125, 256-124, 256-123, 256-122, 256-121, 256-120,
		256-119, 256-118, 256-117, 256-116, 256-115, 256-114, 256-113, 256-112, 256-111, 256-110,
		256-109, 256-108, 256-107, 256-106, 256-105, 256-104, 256-103, 256-102, 256-101, 256-100,
		256-99, 256-98, 256-97, 256-96, 256-95, 256-94, 256-93, 256-92, 256-91, 256-90,
		256-89, 256-88, 256-87, 256-86, 256-85, 256-84, 256-83, 256-82, 256-81, 256-80,
		256-79, 256-78, 256-77, 256-76, 256-75, 256-74, 256-73, 256-72, 256-71, 256-70,
		256-69, 256-68, 256-67, 256-66, 256-65, 256-64, 256-63, 256-62, 256-61, 256-60,
		256-59, 256-58, 256-57, 256-56, 256-55, 256-54, 256-53, 256-52, 256-51, 256-50,
		256-49, 256-48, 256-47, 256-46, 256-45, 256-44, 256-43, 256-42, 256-41, 256-40,
		256-39, 256-38, 256-37, 256-36, 256-35, 256-34, 256-33, 256-32, 256-31, 256-30,
		256-29, 256-28, 256-27, 256-26, 256-25, 256-24, 256-23, 256-22, 256-21, 256-20,
		256-19, 256-18, 256-17, 256-16, 256-15, 256-14, 256-13, 256-12, 256-11, 256-10,
		256-9, 256-8, 256-7, 256-6, 256-5, 256-4, 256-3, 256-2, 256-1,
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
		10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
		20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
		30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
		40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
		50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
		60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
		70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
		80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
		90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
		100, 101, 102, 103, 104, 105, 106, 107, 108, 109,
		110, 111, 112, 113, 114, 115, 116, 117, 118, 119,
		120, 121, 122, 123, 124, 125, 126, 127
	};

	public static int REPEAT = 100000;
	public static int convert(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			int i1 = input[byteOff++];
			if(i1 >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
		}

		return charOff - charStart;
	}
	public static int converta(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < max;)
		{
			int i1 = input[byteOff++];
			if(i1 >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;

	}
	public static int convertb(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		int i1;
		for(int byteOff = byteStart; byteOff < max;)
		{
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;

	}
	public static int convertc(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		int i1;
		if (max-byteStart > 10)
		{
			max -= 10;
			int byteOff = byteStart;
			for(; byteOff < max;)
			{
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			}

			max += 10;
			for(; byteOff < max;)
			{
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			}
		}
		else
		{
			for(int byteOff = byteStart; byteOff < max;)
			{
			if( (i1 = input[byteOff++]) >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = (char)(256 + i1);
			}
		}

		if(throwException)
			throw new Exception();

		return charOff - charStart;

	}
	public static int convert1(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			int i1 = input[byteOff++];
			if(i1 >= 0)
				output[charOff++] = MAP1[i1];
			else
				output[charOff++] = (char)(256 + i1);
		}

		return charOff - charStart;
	}
	public static int convert2(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			int i1 = input[byteOff++];
			if(i1 >= 0)
				output[charOff++] = (char)i1;
			else
				output[charOff++] = MAP2[128 + i1];
		}

		return charOff - charStart;
	}
	public static int convert3(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			int i1 = input[byteOff++];
			output[charOff++] = MAP3[128 + i1];
		}

		return charOff - charStart;
	}
	public static int convert4(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			output[charOff++] = MAP3[128 + input[byteOff++]];
		}

		return charOff - charStart;
	}
	public static int convert5(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			int i1 = input[byteOff++];
			output[charOff++] = (char) (i1 + MAP4[128 + i1]);
		}

		return charOff - charStart;
	}
	public static int convert6(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < byteEnd;)
		{
			if(charOff >= charEnd)
				throw new Exception();
			output[charOff++] = (char) MAP5[128 + input[byteOff++]];
		}

		return charOff - charStart;
	}
	public static int convert7(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < max;)
		{
			output[charOff++] = MAP3[input[byteOff++]+128];
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert7a(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < max;)
		{
			output[charOff++] = (char)(input[byteOff++] & 0xFF);
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert8(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < max;)
		{
			output[charOff++] = (char) MAP5[input[byteOff++]+128];
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert8a(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		for(int byteOff = byteStart; byteOff < max;)
		{
			output[charOff++] = (char)(input[byteOff++] & 0xFF);
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert9(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		if (max-byteStart > 10)
		{
			max -= 10;
			int byteOff = byteStart;
			for(; byteOff < max;)
			{
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
				output[charOff++] = MAP3[input[byteOff++]+128];
			}

			max += 10;
			for(; byteOff < max;)
			{
				output[charOff++] = MAP3[input[byteOff++]+128];
			}
		}
		else
		{
			for(int byteOff = byteStart; byteOff < max;)
			{
				output[charOff++] = MAP3[input[byteOff++]+128];
			}
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert9a(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		if (max-byteStart > 10)
		{
			max -= 10;
			int byteOff = byteStart;
			for(; byteOff < max;)
			{
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
			}

			max += 10;
			for(; byteOff < max;)
			{
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
			}
		}
		else
		{
			for(int byteOff = byteStart; byteOff < max;)
			{
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
			}
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert10(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		if (max-byteStart > 10)
		{
			max -= 10;
			int byteOff = byteStart;
			for(; byteOff < max;)
			{
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
			}

			max += 10;
			for(; byteOff < max;)
			{
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
			}
		}
		else
		{
			for(int byteOff = byteStart; byteOff < max;)
			{
				output[charOff++] = (char) MAP5[input[byteOff++]+128];
			}
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}
	public static int convert10a(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd)
		throws Exception
	{
		int max = byteEnd;
		boolean throwException = false;
		if ( byteEnd-byteStart > charEnd-charStart )
		{
			max = byteStart+(charEnd-charStart);
			throwException = true;
		}

		int charOff = charStart;
		if (max-byteStart > 10)
		{
			max -= 10;
			int byteOff = byteStart;
			for(; byteOff < max;)
			{
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
			}

			max += 10;
			for(; byteOff < max;)
			{
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
			}
		}
		else
		{
			for(int byteOff = byteStart; byteOff < max;)
			{
				output[charOff++] = (char)(input[byteOff++] & 0xFF);
			}
		}
		if(throwException)
			throw new Exception();

		return charOff - charStart;
	}

	public static void main(String[] args)
	{
          maintest(args);
          if (args.length == 2)
            maintest(args);
        }

	public static void maintest(String[] args)
	{
          if (args.length > 0)
            REPEAT = Integer.parseInt(args[0]);
		try
		{
			byte[] b = {
				1,2,55,99,-35,-64,-127,44,111,127,
				10,20,5,9,-5,-6,-27,4,11,17,
				110,112,-55,-99,35,64,127,-44,-111,27,
				100,62,54,109,-115,-96,-17,33,11,7,
				18,28,58,98,-38,-86,-87,48,108,28,
				1,2,55,99,-35,-64,-127,44,111,127,
				10,20,5,9,-5,-6,-27,4,11,17,
				110,112,-55,-99,35,64,127,-44,-111,27,
				100,62,54,109,-115,-96,-17,33,11,7,
				18,28,58,98,-38,-86,-87,48,108,28,
			};
			char[] c = new char[100];

			long time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				converta(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("converta took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convertb(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convertb took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convertc(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convertc took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert1(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert1 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert2(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert2 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert3(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert3 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert4(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert4 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert5(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert5 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert6(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert6 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert7(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert7 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert7a(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert7a took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert8(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert8 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert8a(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert8a took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert9(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert9 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert9a(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert9a took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert10(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert10 took " + time);

			time = System.currentTimeMillis();
			for (int i = REPEAT; i > 0 ; i--)
				convert10a(b,0,b.length,c,0,b.length);
			time = System.currentTimeMillis() - time;
			System.out.println("convert10a took " + time);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}
}