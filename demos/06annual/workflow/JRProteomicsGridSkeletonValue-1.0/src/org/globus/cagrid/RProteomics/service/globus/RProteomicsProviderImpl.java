/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-general/LICENSE.txt for details.
*============================================================================
**/
package org.globus.cagrid.RProteomics.service.globus;

import org.globus.cagrid.RProteomics.common.RProteomicsI;
import org.globus.cagrid.RProteomics.service.RProteomicsImpl;

import java.rmi.RemoteException;

/** 
 *  DO NOT EDIT:  This class is autogenerated!
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class RProteomicsProviderImpl{
	
	RProteomicsI impl;
	
	public RProteomicsProviderImpl() {
		impl = new RProteomicsImpl();
	}
	































































































































































































































































































































































































































































































































































































































































































































































































































	public org.globus.cagrid.RProteomics.stubs.Normalize_logResponse normalize_log(org.globus.cagrid.RProteomics.stubs.Normalize_log params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_logResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_logResponse();
		boxedResult.setResponse(impl.normalize_log(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_log10Response normalize_log10(org.globus.cagrid.RProteomics.stubs.Normalize_log10 params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_log10Response boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_log10Response();
		boxedResult.setResponse(impl.normalize_log10(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_log2Response normalize_log2(org.globus.cagrid.RProteomics.stubs.Normalize_log2 params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_log2Response boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_log2Response();
		boxedResult.setResponse(impl.normalize_log2(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_sqrtResponse normalize_sqrt(org.globus.cagrid.RProteomics.stubs.Normalize_sqrt params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_sqrtResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_sqrtResponse();
		boxedResult.setResponse(impl.normalize_sqrt(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_squareResponse normalize_square(org.globus.cagrid.RProteomics.stubs.Normalize_square params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_squareResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_squareResponse();
		boxedResult.setResponse(impl.normalize_square(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_cubeRootResponse normalize_cubeRoot(org.globus.cagrid.RProteomics.stubs.Normalize_cubeRoot params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_cubeRootResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_cubeRootResponse();
		boxedResult.setResponse(impl.normalize_cubeRoot(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_powerResponse normalize_power(org.globus.cagrid.RProteomics.stubs.Normalize_power params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_powerResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_powerResponse();
		boxedResult.setResponse(impl.normalize_power(params.getLsids(),params.getExponent()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_byMaxResponse normalize_byMax(org.globus.cagrid.RProteomics.stubs.Normalize_byMax params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_byMaxResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_byMaxResponse();
		boxedResult.setResponse(impl.normalize_byMax(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMaxResponse normalize_usingMinAndMax(org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMax params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMaxResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMaxResponse();
		boxedResult.setResponse(impl.normalize_usingMinAndMax(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_IOCResponse normalize_IOC(org.globus.cagrid.RProteomics.stubs.Normalize_IOC params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_IOCResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_IOCResponse();
		boxedResult.setResponse(impl.normalize_IOC(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_quantileResponse normalize_quantile(org.globus.cagrid.RProteomics.stubs.Normalize_quantile params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_quantileResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_quantileResponse();
		boxedResult.setResponse(impl.normalize_quantile(params.getLsids(),params.getStartQuantile()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValueResponse normalize_quantileByValue(org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValueResponse();
		boxedResult.setResponse(impl.normalize_quantileByValue(params.getScanFeaturesXml(),params.getStartQuantile()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_MADResponse denoise_MAD(org.globus.cagrid.RProteomics.stubs.Denoise_MAD params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_MADResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_MADResponse();
		boxedResult.setResponse(impl.denoise_MAD(params.getLsids(),params.getWindowSize(),params.getPercentile(),params.getValuesNearCutoff(),params.getLambda()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalizeResponse denoise_MADNormalize(org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalize params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalizeResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalizeResponse();
		boxedResult.setResponse(impl.denoise_MADNormalize(params.getLsids(),params.getWindowSize(),params.getPercentile(),params.getValuesNearCutoff(),params.getLambda(),params.getMinNoise()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTResponse denoise_waveletUDWT(org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWT params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTResponse();
		boxedResult.setResponse(impl.denoise_waveletUDWT(params.getLsids(),params.getWindowSize(),params.getThresholdMultiplier()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWResponse denoise_waveletUDWTW(org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTW params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWResponse();
		boxedResult.setResponse(impl.denoise_waveletUDWTW(params.getLsids(),params.getWindowSize(),params.getThresholdMultiplier()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValueResponse denoise_waveletUDWTWByValue(org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValueResponse();
		boxedResult.setResponse(impl.denoise_waveletUDWTWByValue(params.getScanFeaturesXml(),params.getWindowSize(),params.getThresholdMultiplier()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_highPassResponse denoise_highPass(org.globus.cagrid.RProteomics.stubs.Denoise_highPass params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_highPassResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_highPassResponse();
		boxedResult.setResponse(impl.denoise_highPass(params.getLsids(),params.getWindowSize(),params.getNumCoeffsToDrop()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_highPassWResponse denoise_highPassW(org.globus.cagrid.RProteomics.stubs.Denoise_highPassW params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_highPassWResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_highPassWResponse();
		boxedResult.setResponse(impl.denoise_highPassW(params.getLsids(),params.getWindowSize(),params.getNumCoeffsToDrop()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilterResponse denoise_PCAFilter(org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilter params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilterResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilterResponse();
		boxedResult.setResponse(impl.denoise_PCAFilter(params.getLsids(),params.getWindowSize(),params.getNumCoeffsToDrop()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilterResponse denoise_q5_PCAFilter(org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilter params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilterResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilterResponse();
		boxedResult.setResponse(impl.denoise_q5_PCAFilter(params.getLsids(),params.getWindowSize(),params.getNumCoeffsToDrop()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Denoise_loessResponse denoise_loess(org.globus.cagrid.RProteomics.stubs.Denoise_loess params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Denoise_loessResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Denoise_loessResponse();
		boxedResult.setResponse(impl.denoise_loess(params.getLsids(),params.getWindowSize(),params.getSpan(),params.getDegree()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileResponse removeBackground_runningQuantile(org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantile params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileResponse();
		boxedResult.setResponse(impl.removeBackground_runningQuantile(params.getLsids(),params.getWindowSize(),params.getPercentile()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValueResponse removeBackground_runningQuantileByValue(org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValueResponse();
		boxedResult.setResponse(impl.removeBackground_runningQuantileByValue(params.getScanFeaturesXml(),params.getWindowSize(),params.getPercentile()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_loessResponse removeBackground_loess(org.globus.cagrid.RProteomics.stubs.RemoveBackground_loess params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_loessResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_loessResponse();
		boxedResult.setResponse(impl.removeBackground_loess(params.getLsids(),params.getWindowSize(),params.getSpan()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFitResponse removeBackground_linearFit(org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFit params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFitResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFitResponse();
		boxedResult.setResponse(impl.removeBackground_linearFit(params.getLsids(),params.getWindowSize()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFitResponse removeBackground_exponentialFit(org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFit params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFitResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFitResponse();
		boxedResult.setResponse(impl.removeBackground_exponentialFit(params.getLsids(),params.getWindowSize()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_logisticResponse removeBackground_logistic(org.globus.cagrid.RProteomics.stubs.RemoveBackground_logistic params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_logisticResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_logisticResponse();
		boxedResult.setResponse(impl.removeBackground_logistic(params.getLsids(),params.getWindowSize()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFitResponse removeBackground_quadraticFit(org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFit params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFitResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFitResponse();
		boxedResult.setResponse(impl.removeBackground_quadraticFit(params.getLsids(),params.getWindowSize()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusResponse removeBackground_minus(org.globus.cagrid.RProteomics.stubs.RemoveBackground_minus params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusResponse();
		boxedResult.setResponse(impl.removeBackground_minus(params.getLsids1(),params.getLsids2()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValueResponse removeBackground_minusByValue(org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValueResponse();
		boxedResult.setResponse(impl.removeBackground_minusByValue(params.getScanFeaturesXml1(),params.getScanFeaturesXml2()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Plot_2DStackedResponse plot_2DStacked(org.globus.cagrid.RProteomics.stubs.Plot_2DStacked params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Plot_2DStackedResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Plot_2DStackedResponse();
		boxedResult.setResponse(impl.plot_2DStacked(params.getLsidsTop(),params.getLsidsBottom()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValueResponse plot_2DStackedByValue(org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValueResponse();
		boxedResult.setResponse(impl.plot_2DStackedByValue(params.getScanFeaturesXmlTop(),params.getScanFeaturesXmlBottom()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Plot_2DResponse plot_2D(org.globus.cagrid.RProteomics.stubs.Plot_2D params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Plot_2DResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Plot_2DResponse();
		boxedResult.setResponse(impl.plot_2D(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Plot_2DByValueResponse plot_2DByValue(org.globus.cagrid.RProteomics.stubs.Plot_2DByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Plot_2DByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Plot_2DByValueResponse();
		boxedResult.setResponse(impl.plot_2DByValue(params.getScanFeaturesXml()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.General_interpolateResponse general_interpolate(org.globus.cagrid.RProteomics.stubs.General_interpolate params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.General_interpolateResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.General_interpolateResponse();
		boxedResult.setResponse(impl.general_interpolate(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.General_interpolateByValueResponse general_interpolateByValue(org.globus.cagrid.RProteomics.stubs.General_interpolateByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.General_interpolateByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.General_interpolateByValueResponse();
		boxedResult.setResponse(impl.general_interpolateByValue(params.getScanFeaturesXml()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Align_alignxResponse align_alignx(org.globus.cagrid.RProteomics.stubs.Align_alignx params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Align_alignxResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Align_alignxResponse();
		boxedResult.setResponse(impl.align_alignx(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.Align_alignxByValueResponse align_alignxByValue(org.globus.cagrid.RProteomics.stubs.Align_alignxByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.Align_alignxByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.Align_alignxByValueResponse();
		boxedResult.setResponse(impl.align_alignxByValue(params.getScanFeaturesXml()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.EchoResponse echo(org.globus.cagrid.RProteomics.stubs.Echo params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.EchoResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.EchoResponse();
		boxedResult.setResponse(impl.echo(params.getLsids()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.EchoByValueResponse echoByValue(org.globus.cagrid.RProteomics.stubs.EchoByValue params) throws RemoteException {
		org.globus.cagrid.RProteomics.stubs.EchoByValueResponse boxedResult = new org.globus.cagrid.RProteomics.stubs.EchoByValueResponse();
		boxedResult.setResponse(impl.echoByValue(params.getScanFeaturesXml()));
		return boxedResult;
	}
	public org.globus.cagrid.RProteomics.stubs.ThrowExceptionResponse throwException(org.globus.cagrid.RProteomics.stubs.ThrowException params) throws RemoteException {
		impl.throwException();
		return new org.globus.cagrid.RProteomics.stubs.ThrowExceptionResponse();
	}

}
