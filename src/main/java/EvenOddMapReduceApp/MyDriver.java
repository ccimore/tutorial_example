package EvenOddMapReduceApp;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver 
{
	public static void main(String[] args) throws IOException,ClassNotFoundException, InterruptedException 
	{

		Path input_file_loc = new Path("hdfs://localhost:9000/user/jivesh/evenodd.txt/");   //harcoded input location
		Path output_dir_loc = new Path("hdfs://localhost:9000/user/jivesh/output/");       //harcoded output location

		Configuration conf = new Configuration();
		Job job = new Job(conf, "Evenodd");  
		
		////name of Driver class
		job.setJarByClass(MyDriver.class);
		//name of mapper class
		job.setMapperClass(MyMapper.class);
		// name of reducer class
		job.setReducerClass(MyReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, input_file_loc);
		FileOutputFormat.setOutputPath(job, output_dir_loc);
		output_dir_loc.getFileSystem(job.getConfiguration()).delete(output_dir_loc,true);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
