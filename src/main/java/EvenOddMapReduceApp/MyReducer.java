package EvenOddMapReduceApp;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> 
{
	
	// reducer will recieve key value pair as  ODD [ 85 131 993 491 539 985 413.....
                                            // 	EVEN [ 392 870 240 888 184 494 704 996 408....
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)	throws IOException, InterruptedException
	{
		int sum = 0;
		if(key.equals("ODD"))
		{
			for (IntWritable value : values)
			{
				sum += value.get();
			}
		}
		else
		{
			for (IntWritable value : values)
			{
				sum += value.get();
		}
		
		}
		context.write(key,new IntWritable(sum));;
	}
}
