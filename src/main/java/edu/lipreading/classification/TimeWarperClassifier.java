package edu.lipreading.classification;

import java.util.List;

import edu.lipreading.Sample;

public class TimeWarperClassifier implements Classifier{

	@Override
	public String classify(List<Sample> trainingSet, Sample test) {
		TimeWarper tw = new TimeWarper();
		double yes = 0, no = 0;
		int yesCount= 0, noCount = 0;
		for (Sample training : trainingSet) {
			if(training.equals(test)){
				if(training.getId().contains("yes")){
					yes += tw.dtw(test, training);
					yesCount++;
				}
				else{
					no += tw.dtw(test, training);
					noCount++;
				}
			}
		}
		if(yes / yesCount < no / noCount)
			return "yes";
		else
			return "no";
	}

}